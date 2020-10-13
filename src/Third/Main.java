package Third;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> cards1 = new LinkedList<>();
        Queue<Integer> cards2 = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 5; i++){
            int a = in.nextInt();
            cards1.add(a);
        }
        for (int i = 0; i < 5; i++){
            int a = in.nextInt();
            cards2.add(a);
        }
        System.out.println(cards1);
        System.out.println(cards2);
        game(cards1, cards2);
    }

    private static void game(Queue<Integer> cards1, Queue<Integer> cards2) {
        int times = 0;
        while((cards1.peek() != null) && (cards2.peek()!= null) && (times < 106)){
            int t = 0;
            //Рассмотр случая выпадения 0-9 и 9-0
            //========================================================
            if (t != 1) {
                if ((cards1.peek() == 0) && (cards2.peek() == 9)) {
                    cards1.add(cards1.poll());
                    cards1.add(cards2.poll());
                    System.out.println("<" + times + ">" + cards1);
                    times += 1;
                    t = 1;
                }
            }
            if (t != 1) {
                if ((cards1.peek() == 9) && (cards2.peek() == 0)) {
                    cards2.add(cards1.poll());
                    cards2.add(cards2.poll());
                    System.out.println("<" + times + ">" + cards2);
                    times += 1;
                    t = 1;
                }
            }
            //==========================================================
            //Рассмотр случая, когда карта певого игрока старше второго
            if (t != 1) {
                if (cards1.peek() > cards2.peek()) {
                    cards1.add(cards1.poll());
                    cards1.add(cards2.poll());
                    System.out.println("<" + times + ">" + cards1);
                    times += 1;
                    t = 1;
                }
            }
            //==========================================================
            //Рассмотр случая, когда карта второго игрока старше первого
            if (t != 1) {
                if (cards1.peek() < cards2.peek()) {
                    cards2.add(cards2.poll());
                    cards2.add(cards1.poll());
                    System.out.println("<" + times + ">" + cards2);
                    times += 1;
                }
            }
        }
        if (cards1.peek() == null)
            System.out.println("second " + times);
        if (cards2.peek() == null)
            System.out.println("first " + times);
        if (times == 106)
            System.out.println("botva");
    }
}
