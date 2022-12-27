package cah;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class exo1 {
    public static void main(String[] args){
        int[][] mat = {
                {11,7,4,6,6,7,4,4,3},
                {7,15,8,8,9,6,3,3,2},
                {4,8,13,7,7,4,2,3,2},
                {6,8,7,15,7,6,6,8,6},
                {6,9,7,7,12,4,3,5,4},
                {7,6,4,6,4,10,6,5,5},
                {4,3,2,6,3,6,13,10,9},
                {4,3,3,8,5,5,10,15,11},
                {3,2,2,6,4,5,9,11,12}
        };

        distance(mat);

    }

    public static void distance(int[][] mat){
        double[][] mat_dist = new double[mat.length][mat[0].length];
        List<Integer> diag = diag(mat);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat_dist[i][j] = (diag.get(i)+diag.get(j)-(2*mat[i][j]))/(double)(diag.get(i)+diag.get(j));
                System.out.print(mat_dist[i][j]+" |");
            }
            System.out.println();
        }
    }

    public static List<Integer> diag(int[][] mat){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            list.add(mat[i][i]);
        }
        return list;
    }
}
