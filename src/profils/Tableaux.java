package profils;

import java.util.ArrayList;
import java.util.List;

public class Tableaux {
    double[][] mat;
    double[][] mat_attendue;
    double[][] mat_distance;
    String[][] mat_explication;
    double[][] mat_profil_ligne;
    double[][] mat_profil_colonne;
    List<Double> total_ligne;
    List<Double> total_colonne;
    int total_global;


    public Tableaux(double[][] mat) {
        this.mat = mat;
        this.mat_attendue = new double[mat.length][mat[0].length];
        this.mat_distance = new double[mat.length][mat[0].length];
        this.mat_explication = new String[mat.length][mat[0].length];
        this.mat_profil_ligne = new double[mat.length][mat[0].length];
        this.mat_profil_colonne = new double[mat.length][mat[0].length];
        this.total_ligne = new ArrayList<>();
        this.total_colonne = new ArrayList<>();
        this.total_global = 0;
    }

    public void valeurs_observes(){
        System.out.println("########_VALEURS_OBSERVEES_#########");
        for (int i = 0; i < this.mat.length; i++) {
            int somme_ligne = 0;
            for (int j = 0; j < this.mat[i].length; j++) {
                somme_ligne+=mat[i][j];
                System.out.print(mat[i][j]+" |");
            }
            this.total_ligne.add((double) somme_ligne);
            System.out.println("  ["+this.total_ligne.get(i)+"]");
        }
        getAllColonnes();
        System.out.print(this.total_colonne);
        System.out.println(" ["+this.total_global+"]");
    }

    public void valeurs_attendues(){
        System.out.println("\n########_VALEURS_ATTENDUES_#########");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                this.mat_attendue[i][j] = this.total_ligne.get(i)*this.total_colonne.get(j)/this.total_global;
                System.out.print(this.mat_attendue[i][j]+" |");
            }
            System.out.println();
        }
    }

    public void distance(){
        System.out.println("\n########_DISTANCES_#########");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                this.mat_distance[i][j] = this.mat[i][j]-mat_attendue[i][j];
                System.out.print(this.mat_distance[i][j]+" |");
            }
            System.out.println();
        }
    }

    public void explication(){
        System.out.println("\n########_EXPLICATION_#########");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat_distance[i][j]>=0)
                    this.mat_explication[i][j] = "Attraction";
                else this.mat_explication[i][j] = "Répulsion";
                System.out.print(this.mat_explication[i][j]+" |");
            }
            System.out.println();
        }
    }

    public void profils_lignes(){
        System.out.println("\n########_PROFILS_LIGNES#########");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                this.mat_profil_ligne[i][j] = this.mat[i][j]/this.total_ligne.get(i);
                System.out.print(this.mat_profil_ligne[i][j]+" |");
            }
            System.out.println();
        }
    }

    public void profils_colonnes(){
        System.out.println("\n########_PROFILS_COLONNES#########");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                this.mat_profil_colonne[i][j] = this.mat[i][j]/this.total_colonne.get(j);
                System.out.print(this.mat_profil_colonne[i][j]+" |");
            }
            System.out.println();
        }
    }

    public void  getAllColonnes(){
        List<List<Double>> list = new ArrayList<>();
        int somme_totale=0;
        for (int i = 0; i < mat[i].length; i++) {
            list.add(getColonne(i));
            somme_totale+=total_colonne.get(i);
        }
        this.total_global = somme_totale;
    }

    public List<Double> getColonne(int col){
        List<Double> tab =new ArrayList<>();
        int somme_colonne = 0;
        for (int i = 0; i < mat.length; i++) {
            tab.add(mat[i][col]);
            somme_colonne+=mat[i][col];
        }
        this.total_colonne.add((double) somme_colonne);
        //System.out.println(tab);
        return tab;
    }
}
