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
public class FileClass2 {
    
   public static void main(String[] args) throws IOException{
       
             File fp = new File("profile.txt");
        
             FileReader fr = new FileReader(fp);
        
             BufferedReader br = new BufferedReader(fr);
             
             System.out.print(br.readLine());
             
             br.close();
   }
}
