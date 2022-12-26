package profils;

public class Programme {
    public static void main(String[] args){

        double[][] matrice = {{80,99,65,58},{168,137,208,62},{470,400,876,79},{145,133,135,54},{166,193,127,129}};

        Tableaux data = new Tableaux(matrice);

        data.valeurs_observes();
        data.valeurs_attendues();
        data.distance();
        data.explication();
        data.profils_lignes();
        data.profils_colonnes();

    }
}
