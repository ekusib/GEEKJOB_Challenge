/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;


import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author guest1Day
 */
public class Dealer extends Human{
    
   ArrayList<Integer> cards = new ArrayList();{
    
    //マーク4つ*(1~10+JQK)をcardsに格納
        for(int mark = 0; mark < 4; mark++){
            for(int oneten = 1; oneten <= 10;oneten++){
                cards.add(oneten); }    
            for(int jqk = 1; jqk <= 3; jqk++){
                cards.add(jqk); }
        }
}
   public ArrayList<Integer> deal(){
       
       //ディーラーの手札になる配列
          ArrayList<Integer> deal = new ArrayList<>();
       //乱数を取得
        Random rnd = new Random();
        
        for (int i = 0; i < 2; i++) {
            int Index = rnd.nextInt(cards.size());
            deal.add(cards.get(Index));
            cards.remove(Index);
        }
        return deal;
   }
   
   public ArrayList<Integer> hit(){
       //ヒット時に渡すカードを入れる配列
       ArrayList<Integer> draw = new ArrayList<>();
       //乱数を取得
       Random rnd = new Random();
       //
       Integer Index = rnd.nextInt(cards.size());
       draw.add(cards.get(Index));
       cards.remove(Index);
       
       return draw;
   }
 
   @Override
   public void setCard(ArrayList<Integer> hand){
       for(int i = 0; i < hand.size(); i++){
           myCards.add(hand.get(i));
       }
   }
   
   @Override
      //手札の合計が17以上になるまでカードを引かなければならない
      public boolean checkSum(){
       
       int total = open();
       return total < 17;
   }
      
   @Override
   
   public int open(){
       
       int total = 0;
       
       for(int i = 0; i < myCards.size(); i++){
           total = total + myCards.get(i);
       }
       return total;
   }
}