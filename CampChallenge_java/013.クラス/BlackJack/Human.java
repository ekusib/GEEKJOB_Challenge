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
abstract public class Human {
    
    abstract public int open();
    abstract public void setCard(ArrayList<Integer> hand);
    abstract public boolean checkSum();

    ArrayList<Integer> myCards = new ArrayList();    
}
