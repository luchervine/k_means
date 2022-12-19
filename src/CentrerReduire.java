import java.util.ArrayList;
import java.util.List;

public class CentrerReduire {
    double[][] mat;

    public CentrerReduire(double[][] mat) {
        this.mat = mat;

        this.centrer();
        this.reduire();
    }

    public void centrer(){
        List<List<Double>> list = getAllColonnes();
        List<Double> moyennes = new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            moyennes.add(moyenne(list.get(i)));
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = mat[i][j]-moyennes.get(j);
                System.out.print(mat[i][j]+" |");
            }
            System.out.println();
        }
    }

    public void reduire(){
        List<Double> sigmas = sigma();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = mat[i][j]/sigmas.get(j);
                System.out.print(mat[i][j]+" |");
            }
            System.out.println();
        }
    }

    public List<Double> sigma(){
        List<List<Double>> list = getAllColonnes();
        List<Double> sigmas = new ArrayList<>();
        List<Double> sommes = new ArrayList<>();

        for (int i = 0; i < mat.length; i++) {
            double somme = 0;
            for (int j = 0; j <mat[i].length ; j++) {
                somme+=Math.pow(mat[i][j], 2);
            }
            sommes.add(somme);
        }

        for (int i = 0; i <list.size() ; i++) {
            sigmas.add(Math.sqrt(sommes.get(i)/mat.length));
        }
        System.out.println("sigma: "+sigmas);
        return sigmas;
    }

    public List<List<Double>>  getAllColonnes(){
        List<List<Double>> list = new ArrayList<>();
        for (int i = 0; i < mat[i].length; i++) {
            list.add(getColonne(i));
        }
        //System.out.println("List"+list);
        return list;
    }

    public List<Double> getColonne(int col){
        List<Double> tab =new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            tab.add(mat[i][col]);
        }
        //System.out.println(tab);
        return tab;
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
