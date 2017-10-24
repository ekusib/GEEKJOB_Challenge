/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author guest1Day
 */
public class BJ extends HttpServlet {

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

            out.print("ブラックジャックを始めます。<br><br>");
            
            Dealer dealer = new Dealer();
            User user = new User();
            
            dealer.setCard(dealer.deal());
            user.setCard(dealer.deal());
            
            out.print("ディーラーの手札：" + dealer.myCards + "<br>合計：" + dealer.open() + "<br>");
            out.print("ユーザーの手札：" + user.myCards + "<br>合計：" +user.open() + "<br>");
            
            int d = 0;
                    
             while(dealer.checkSum() == true){
                 dealer.setCard(dealer.hit());
                 d++;
            }
            
                out.print("最終的なディーラーの手札：" + dealer.myCards + "<br>合計：" + dealer.open() + "<br>");
            
                
                int u = 0;
                
            while (user.checkSum() == true) {
                user.setCard(dealer.hit());
                u++; 
            }
            
                out.print("最終的なユーザーの手札：" + user.myCards + "<br>合計：" + user.open() + "<br>");
           
            
                 if (user.open() >= 22 && dealer.open() >= 22) {
                
                     out.print("引き分けです。<br>");
                
            } else if (user.open() >= 22) {
                
                out.print("ディーラー：勝ち<br>ユーザー：負け<br>");
                
            } else if (dealer.open() >= 22) {
                
                out.print("ディーラー：負け<br>ユーザー：勝ち<br>");
               
            }else if (user.open() > dealer.open()) {
                
                out.print("ディーラー：負け<br>ユーザー：勝ち<br>");
                
            } else if (user.open() < dealer.open()) {
                
                out.print("ディーラー：勝ち<br>ユーザー：負け<br>");
                
            } else {
                
                out.print("引き分け");
            
            }
        
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
