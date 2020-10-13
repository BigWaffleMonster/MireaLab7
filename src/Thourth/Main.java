package Thourth;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> cards1 = new Stack<Integer>();
        Stack<Integer> cards2 = new Stack<Integer>();
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 5; i++){
            int a = in.nextInt();
            cards1.push(a);
        }
        for (int i = 0; i < 5; i++){
            int a = in.nextInt();
            cards2.push(a);
        }
        game(cards1, cards2);
    }

    private static void game(Stack<Integer> cards1, Stack<Integer> cards2) {
        int times = 0, t = 0;
        while((cards1.empty() == false) && (cards2.empty() == false) && (times < 106)){
            Stack<Integer> tCards = new Stack<Integer>();
            Stack<Integer> copyCards = new Stack<Integer>();
            //Рассмотр случая выпадения 0-9 и 9-0
            //========================================================
            if ((cards1.peek() == 0) && (cards2.peek() == 9) && (t == 0)) {
                tCards.push(cards1.pop());
                tCards.push(cards2.pop());
                while (cards1.empty() == false) {
                    copyCards.push(cards1.pop());
                }
                while (copyCards.empty() == false){
                    tCards.push(copyCards.pop());
                }
                cards1 = tCards;
                times += 1;
                t = 1;
            }
            if ((cards1.peek() == 9) && (cards2.peek() == 0) && (t == 0)) {
                tCards.push(cards1.pop());
                tCards.push(cards2.pop());
                while (cards2.empty() == false) {
                    copyCards.push(cards2.pop());
                }
                while (copyCards.empty() == false){
                    tCards.push(copyCards.pop());
                }
                cards2 = tCards;
                times += 1;
                t = 1;
            }
            //==========================================================
            //Рассмотр случая, когда карта певого игрока старше второго
            if (cards1.peek() > cards2.peek() && (t == 0)) {
                tCards.push(cards1.pop());
                tCards.push(cards2.pop());
                while (cards1.empty() == false) {
                    copyCards.push(cards1.pop());
                }
                while (copyCards.empty() == false){
                    tCards.push(copyCards.pop());
                }
                cards1 = tCards;
                times += 1;
                t = 1;
            }
            //==========================================================
            //Рассмотр случая, когда карта второго игрока старше первого
            if (cards1.peek() < cards2.peek() && (t == 0)) {
                tCards.push(cards2.pop());
                tCards.push(cards1.pop());
                while (cards2.empty() == false) {
                    copyCards.push(cards2.pop());
                }
                while (copyCards.empty() == false){
                    tCards.push(copyCards.pop());
                }
                cards2 = tCards;
                times += 1;
            }
            t = 0;
        }
        if (cards1.empty() == true)
            System.out.println("second " + times);
        if (cards2.empty() == true)
            System.out.println("first " + times);
        if (times == 106)
            System.out.println("botva");
    }
}