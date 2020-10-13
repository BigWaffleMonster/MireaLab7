package Second;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Double> cards1 = new ArrayList<Double>();
        ArrayList<Double> cards2 = new ArrayList<Double>();
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            double a = in.nextInt();
            cards1.add(i, a);
        }
        for (int i = 0; i < 5; i++) {
            double a = in.nextInt();
            cards2.add(i, a);
        }
        game(cards1, cards2);
    }

    private static void game(ArrayList<Double> cards1, ArrayList<Double> cards2) {
        int times = 0;
        while((cards1.size() != 10) && (cards2.size()!= 10) && (times < 106)){
            int t = 0;
            double last1;
            double last2;
            //Рассмотр случая выпадения 0-9 и 9-0
            //========================================================
            if ((cards1.get(0) == 0) && (cards2.get(0) == 9)) {
                last1 = cards1.remove(0);
                last2 = cards2.remove(0);
                cards1.add(cards1.size(), last1);
                cards1.add(cards1.size(), last2);
                times += 1;
                t = 1;
            }
            if (t != 1) {
                if ((cards1.get(0) == 9) && (cards2.get(0) == 0)) {
                    last1 = cards1.remove(0);
                    last2 = cards2.remove(0);
                    cards2.add(cards2.size(), last1);
                    cards2.add(cards2.size(), last2);
                    times += 1;
                    t = 1;
                }
            }
            //==========================================================
            //Рассмотр случая, когда карта певого игрока старше второго
            if (t != 1) {
                if (cards1.get(0) > cards2.get(0)) {
                    last1 = cards1.remove(0);
                    last2 = cards2.remove(0);
                    cards1.add(cards1.size(), last1);
                    cards1.add(cards1.size(), last2);
                    times += 1;
                    t = 1;
                }
            }
            //==========================================================
            //Рассмотр случая, когда карта второго игрока старше первого
            if (t != 1) {
                if (cards1.get(0) < cards2.get(0)) {
                    last1 = cards1.remove(0);
                    last2 = cards2.remove(0);
                    cards2.add(cards2.size(), last1);
                    cards2.add(cards2.size(), last2);
                    times += 1;
                }
            }
        }
        if (cards1.size() == 0)
            System.out.println("second " + times);
        if (cards2.size() == 0)
            System.out.println("first " + times);
        if (times == 106)
            System.out.println("botva");
    }
}