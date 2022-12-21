package anova;

import java.util.List;

public class Risque {
    List<int[]> data;
    double sce_t;
    double sce_a;
    double sce_r;

    public Risque(List<int[]> data) {
        this.data = data;
        this.sce_t = 0;
        this.sce_a = 0;
        this.sce_r = 0;
    }

    //SCE_T
    public void calcul_sceT(){
        int somme_y2 =0;
        int somme_T = 0;
        int somme_N = 0;
        for (int i = 0; i < data.size(); i++) {
            somme_y2+=somme2(data.get(i));
            somme_T+=somme(data.get(i));
            somme_N+=data.size();
        }

        this.sce_t = somme_y2 - ((Math.pow(somme_T, 2)/somme_N));
        //System.out.println(this.sce_t +" = "+ somme_y2+" - ( "+Math.pow(somme_T, 2)+"/"+somme_N+")");
        System.out.println("SCE_T = "+this.sce_t);
    }
    //SCE_A
    public void calcul_sceA(){
        double somme=0;
        int somme_T=0;
        int somme_N =0;
        for (int i = 0; i < data.size(); i++) {
            somme += Math.pow(somme(data.get(i)),2)/data.get(i).length;
            somme_T+=somme(data.get(i));
            somme_N+=data.size();
        }
        
        this.sce_a = somme - (Math.pow(somme_T, 2)/somme_N);
        //System.out.println(this.sce_a +" = "+ somme+" - ( "+Math.pow(somme_T, 2)+"/"+somme_N+")");
        System.out.println("SCE_A = "+this.sce_a);
    }

    //SCE_R
    public void calcul_sceR(){
        this.sce_r = this.sce_t - this.sce_a;
        System.out.println("SCE_R = "+this.sce_r);
    }
    
    //Somme simple
    public int somme(int[] tab){
        int somme = 0;
        for (int i = 0; i < tab.length; i++) {
            somme+=tab[i];
        }
        return somme;
    }

    //Somme des carrés
    public int somme2(int[] tab){
        int somme = 0;
        for (int i = 0; i < tab.length; i++) {
            somme+=Math.pow(tab[i], 2);
        }
        return somme;
    }

    public void affichage(int ddl_t, int ddl_a, int ddl_r){
        System.err.println(" SV  |   SCE   |  ddl  |   CM    |   F   ");
        System.err.println("_________________________________________");
        System.err.println("  A  |  "+this.sce_a+"  |   "+ddl_a+"   |  "+this.sce_a/ddl_a+"   |   "+(this.sce_a/ddl_a)/(this.sce_r/ddl_r)+"   ");
        System.err.println("  R  |   "+this.sce_r+"  |   "+ddl_r+"   |  "+this.sce_r/ddl_r+"   |       ");
        System.err.println("  T  |  "+this.sce_t+"  |   "+ddl_t+"   |         |       ");
    }
}
