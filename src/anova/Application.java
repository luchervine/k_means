package anova;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args){
        List<int[]> data = new ArrayList<>();
        List<int[]> data1 = new ArrayList<>();
        data.add(new int[]{21, 20, 16});
        data.add(new int[]{16,18,11});
        data.add(new int[]{23,31,24});

        data1.add(new int[]{4,5,10,4,3,11,14,6,10,12});
        data1.add(new int[]{21,19,24,17,16,25,24,22,21,21});

        Risque risque = new Risque(data1);
        risque.calcul_sceT();
        risque.calcul_sceA();
        risque.calcul_sceR();
        risque.affichage();
    }
}
