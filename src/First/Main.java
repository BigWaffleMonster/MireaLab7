package First;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayDeque<Integer> cards1 = new ArrayDeque<Integer>();
        ArrayDeque<Integer> cards2 = new ArrayDeque<Integer>();
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            int a = in.nextInt();
            cards1.push(a);
        }
        for (int i = 0; i < 5; i++) {
            int a = in.nextInt();
            cards2.push(a);
        }
        game(cards1, cards2);
    }

    private static void game(ArrayDeque<Integer> cards1, ArrayDeque<Integer> cards2) {
        int times = 0;
        while((cards1.peek() != null) && (cards2.peek()!= null) && (times < 106)){
            int t = 0;
            //Рассмотр случая выпадения 0-9 и 9-0
            //========================================================
            if (t != 1) {
                if ((cards1.peekFirst() == 0) && (cards2.peekFirst() == 9)) {
                    cards1.addLast(cards1.pop());
                    cards1.addLast(cards2.pop());
                    times += 1;
                    t = 1;
                }
            }
            if (t != 1) {
                if ((cards1.peekFirst() == 9) && (cards2.peekFirst() == 0)) {
                    cards2.addLast(cards1.pop());
                    cards2.addLast(cards2.pop());
                    times += 1;
                    t = 1;
                }
            }
            //==========================================================
            //Рассмотр случая, когда карта певого игрока старше второго
            if (t != 1) {
                if (cards1.peekFirst() > cards2.peekFirst()) {
                    cards1.addLast(cards1.pop());
                    cards1.addLast(cards2.pop());
                    times += 1;
                    t = 1;
                }
            }
            //==========================================================
            //Рассмотр случая, когда карта второго игрока старше первого
            if (t != 1) {
                if (cards1.peekFirst() < cards2.peekFirst()) {
                    cards2.addLast(cards2.pop());
                    cards2.addLast(cards1.pop());
                    times += 1;
                }
            }
        }
        if (cards1.peekFirst() == null)
            System.out.println("second " + times);
        if (cards2.peekFirst() == null)
            System.out.println("first " + times);
        if (times == 106)
            System.out.println("botva");
    }
}
