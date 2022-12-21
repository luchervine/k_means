package anova;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args){
        List<int[]> data = new ArrayList<>();
        data.add(new int[]{21, 20, 16});
        data.add(new int[]{16,18,11});
        data.add(new int[]{23,31,24});

        Risque risque = new Risque(data);
        risque.calcul_sceT();
        risque.calcul_sceA();
        risque.calcul_sceR();
        risque.affichage(8, 2, 6);
    }
}
