/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guest1Day
 * 課題内容
 * 3人のプロフィール情報をもった配列をメソッドに用意
 * 引数で受け取った値をIDを比較し、一致するプロフィールを返して表示する
 *
 */
public class hikimodo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    String[] myprofile(int num){

      String[] data1 ={"ID：" + num + "<br>","名前：野原しんのすけ<br>","生年月日：1987年5月5日<br>","住所：埼玉県<br>"};
      String[] data2 ={"ID：" + num + "<br>","名前：野比のび太<br>","生年月日：1967年8月7日<br>","住所：東京都<br>"};
      String[] data3 ={"ID：" + num + "<br>","名前：ミッキーマウス<br>","生年月日：1928年11月18日<br>","住所：世界<br>"};
      String[] data4 ={"ID：" + num + "<br>","IDに該当するデータを見つけることができませんでした。"};

      if(num == 1){
          return data1;
      }else if(num == 2){
          return data2;
      }else if(num == 3){
          return data3;
      }else{
          return data4;
      }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String [] profile =myprofile(3);

            out.print(profile[1]);
            out.print(profile[2]);
            out.print(profile[3]);


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
