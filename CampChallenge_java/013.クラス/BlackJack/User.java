/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.util.ArrayList;

/**
 *
 * @author guest1Day
 */
public class User extends Human {
    
    @Override
    public void setCard(ArrayList<Integer> hand){
       for(int i = 0; i < hand.size(); i++){
           myCards.add(hand.get(i));
       }
   }
   
   @Override
      //手札の合計が20以下ならhitする
      public boolean checkSum(){
       
       int total = open();
       return total < 21;
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

