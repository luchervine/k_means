import java.util.*;

public class KMeans {
    int k;
    int mat[][];
    List<Integer> centroid;
    Map<String, List<Integer>> groupes;
    Random rd = new Random();

    public KMeans(int k, int[][] mat) {
        this.k = k;
        this.mat = mat;
        this.centroid = new ArrayList<>();
        this.groupes = new HashMap<>();
    }

    public void first_centroid(){
            if (mat.length!=0 && mat[0].length!=0){
                for (int k = 0; k < this.k; k++) {
                    int i = rd.nextInt(mat.length);
                    int j = rd.nextInt(mat[i].length);
                    System.out.print("(i,j) : ("+i+","+j+")");
                    System.out.println("C"+k+" = "+mat[i][j]);
                    centroid.add(mat[i][j]);
                }
                System.out.println(centroid);
            }else
                System.err.println("Veuillez entrer une matrice!");
    }

    public void affectation(){
        List<Double> distances = new ArrayList<>();
        Map<Integer, Double> distances_c = new HashMap<Integer, Double>();
        for (int i = 0; i <mat.length ; i++) {
            for (int j = 0; j <mat[i].length ; j++) {
                for (int l = 0; l < this.k; l++) {
                    double a = Math.sqrt(Math.pow((centroid.get(l) - mat[i][j]), 2));
                    System.out.print("a"+l+" = "+a+", ");
                    distances.add(a);
                    distances_c.put(centroid.get(l), a);
                }
                //Trie Ordre Croissant
                Collections.sort(distances);
                //Plus petite distance
                System.out.println("d["+i+" "+j+"] : "+distances.get(0));
                System.out.println("dico: "+distances_c.toString());
                for (int l = 0; l < this.k; l++) {
                    int finalI = i;
                    int finalJ = j;
                    int finalL = l;
                    distances_c.forEach((c, d) ->{
                    });
                    System.out.println("Groupes: "+groupes.toString());
                }
                distances.clear();
            }
            System.out.println();
        }
    }
}
