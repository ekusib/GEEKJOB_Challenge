/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;
/**
 *
 * @author guest1Day
 */

//Humanクラスの宣言
public class Human {
    //フィールドの宣言
    public String name = "";
    public int age = 0;
    
    //メソッドの宣言
   public void setHuman(String n,int a){
       //引数をフィールドへ設定
       this.name = n;
       this.age = a;
   }
    
   public void printHuman(){
       
       System.out.print("氏名" + name + "<br>" + "年齢" + age + "<br>");
   }
}

