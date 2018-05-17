/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;
/**
 *
 * @author guest1Day
 * 課題内容
 * 以下の仕様が満たされるクラスとそれを実行するクラスを作成して実行してください
 * 2つのフィールドを持つ
 * 2つの引数を持ち、受け取った2つの値をフィールドに格納するメソッドを持つ
 * 2つのフィールドの値を出力するメソッドを持つ
 */

public class Jikkou{

	public static void main(String[] args) {

		Human human = new Humam();

		human.setHuman("山崎", 23);
		human.printHuman();
	}
}
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

