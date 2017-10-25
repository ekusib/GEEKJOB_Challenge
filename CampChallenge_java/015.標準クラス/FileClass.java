/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.*;
/**
 *
 * @author guest1Day
 */
public class FileClass {
    
   public static void main(String[] args) throws IOException{
       
             File fp = new File("profile.txt");
        
             FileWriter fw = new FileWriter(fp);
        
             fw.write("こんにちは。山崎大夢です。");
             
             fw.close();
   }
}
