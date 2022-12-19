import java.util.*;

public class K_Means {
    int k;
    double mat[][];
    int max_iter;
    List<Double> centroid;
    int cmpt; //l'indice du centroid le plus proche
    Map<Integer, List<Double>> groupes;
    Random rd = new Random();
    CentrerReduire cr;

    public K_Means(int k, double[][] mat, int max_iter) {
        this.k = k;
        this.mat = mat;
        this.max_iter = max_iter;
        this.cmpt = 0;
        this.centroid = new ArrayList<>();
        this.groupes = new HashMap<>();

        this.cr = new CentrerReduire(mat);
    }
    public K_Means(double[][] mat) {
        this.k = 2;
        this.mat = mat;
        this.max_iter = 100;
        this.cmpt = 0;
        this.centroid = new ArrayList<>();
        this.groupes = new HashMap<>();

        this.cr = new CentrerReduire(mat);
    }

    public void first_centroid(){
        if (mat.length!=0 && mat[0].length!=0){
            for (int k = 0; k < this.k; k++) {
                int i = rd.nextInt(mat.length);
                int j = rd.nextInt(mat[i].length);
                System.out.print("(i,j) : ("+i+","+j+")");
                System.out.println("C"+k+" = "+mat[i][j]);
                centroid.add((double) mat[i][j]);
                groupes.put(k, new ArrayList<>());
            }
            System.out.println(centroid);
        }else
            System.err.println("Veuillez entrer une matrice!");
    }

    public void nearest_centroid(){
        for (int k = 0; k < this.k; k++) {
            groupes.put(k, new ArrayList<>());
        }
        for(int i=0; i<mat.length; i++){
            for (int j = 0; j <mat[i].length ; j++) {
                for(double c: centroid){
                    double dist = distance(c, mat[i][j]); // La distance entre chaque cluster et chaque donnée
                    double dist1 = distance(centroid.get(cmpt), mat[i][j]); // La distance entre le cluster le plus proche et chaque donnée

                    if (dist<dist1)
                        cmpt =centroid.indexOf(c);
                    else
                        cmpt = centroid.indexOf(centroid.get(cmpt));
                }
                groupes.get(cmpt).add(mat[i][j]);
            }
        }
    }

    public void new_centroid(){
        for (int i = 0; i < groupes.size(); i++) {
            centroid.set(i, moyenne(groupes.get(i)));
        }
        System.out.println("New Centroid :"+centroid);
    }

    // Methode Pour Calculer la distance entre deux points de données;
    public double distance(double c, double p){
        double dist =0;

        dist = Math.sqrt(Math.pow((c - p), 2));

        return dist;
    }

    //Methode pour calculer la moyenne d'un cluster
    public double moyenne(List<Double> list){
        double moy = 0;
        double somme = 0;

        for (double a: list){
            somme+=a;
        }
        moy = (somme/list.size());

        return moy;
    }

}
