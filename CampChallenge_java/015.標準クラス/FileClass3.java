/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guest1Day
 */
public class FileClass3 extends HttpServlet {

        
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        Date start = new Date();
        
        File fp = new File("log.txt");
        FileWriter fw = new FileWriter(fp);

        fw.write(sdf.format(start) + "　　開始<br><br>");
        
        try(PrintWriter pw = new PrintWriter(fw)){
       
        double r = (Math.random()*10);
        r = Math.ceil(r);
          
        pw.println("1~10の数値をランダムに表示 r = " + r + "<br>");
        
        double circle;
        
        circle = r * r * Math.PI;
        
        pw.println("rを半径としたときの円の面積 = " + circle + "<br><br>");
        
        double num = -28;
        
        pw.println("num = " + num + "<br>");
        pw.println("numの絶対値 = " + Math.abs(num) + "<br><br>");
        
        Date end = new Date();
        fw.write(sdf.format(end) + "　　終了");
        
       
        }
        
        FileReader fr = new FileReader(fp);
        BufferedReader br = new BufferedReader(fr);
        
        String read = br.readLine();
        while (read != null) {
            out.println(read);
            read = br.readLine();
        }
        br.close();
        
        
        }
    }

        
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
