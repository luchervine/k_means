import java.util.List;

public class Main {
    public static void main(String[] args){
        double[][] mat = {{2,7,3},{5,6,4},{8,4,7},{9,11,13}};
        double[][] ma ={{4},{47},{74},{45}};
        double[][] simple_mat = {{2,2,3},{3,1,2},{1,0,3},{2,1,4},{2,1,3}};

        /*KMeans kmeans = new KMeans(2, mat);
        kmeans.first_centroid();
        kmeans.affectation();*/

        /* Constructeur avec 3 paramètres
        * int k: le nombre de clusters
        * int[][] mat: la matrice de données
        *int max_iter: Le nombre d'itérations
        * */
        K_Means k_means = new K_Means(2, mat, 10);
        k_means.first_centroid();                       //Methode pour déterminer aléatoirement les premiers centroids
        k_means.nearest_centroid();                     //Méthode pour déterminer les centroids les plus proches
        System.out.println("Groupes : "+ k_means.groupes.toString());
        k_means.new_centroid();                         //Méthode pour déterminer les nouveaux centroids

        //Répétition en fonction du nombre d'itérations
        for (int i = 0; i < k_means.max_iter; i++) {
            k_means.nearest_centroid();
            System.out.println("Groupes : "+ k_means.groupes.toString());
            List last_centroid = k_means.centroid;
            k_means.new_centroid();
            List current_centroid = k_means.centroid;
        }
        System.out.println("FINAL_GROUP : "+ k_means.groupes.toString()); //Affichage final des clusters

    }
}
