/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 *
 * @author guest1Day
 */
public class DB_sousa6 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
        Connection db_con = null;
        PreparedStatement db_st_select = null;
        PreparedStatement db_st_delete = null;
        ResultSet db_data1 = null;
        ResultSet db_data2 = null;
        
        String profiles_Delete = "DELETE FROM profiles WHERE profilesID = 3";
        String profiles_Select = "SELECT * FROM profiles";
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "ekusib", "rvw29hcu");

            db_st_delete = db_con.prepareStatement(profiles_Delete);
            int i = db_st_delete.executeUpdate();
            
            System.out.print(i);
            
            db_st_select = db_con.prepareStatement(profiles_Select);
            db_data2 = db_st_select.executeQuery();
            
            out.print(" profilesID / name / tel /age / birthday<br><br>");
            
            while(db_data2.next()){
            
            out.println(db_data2.getInt("profilesID") + " /");
            out.println(db_data2.getString("name") + " /");
            out.println(db_data2.getString("tel") + " /");
            out.println(db_data2.getInt("age") + " /");
            out.println(db_data2.getString("birthday"));
            out.println("<br>");
            
            }
            
            db_data1.close();
            db_data2.close();
            db_st_select.close();
            db_st_delete.close();
            db_con.close();

        } catch (SQLException e_sql) {
            
            System.out.println("接続時にエラーが発生しました。" + e_sql.toString());
          
        } catch (Exception e) {
            
            System.out.println("エラーが発生しました。"+ e.toString());
        
        } finally {
          
            if (db_con != null) {
                try {
                    db_con.close();
                } catch (Exception e_con) {
                    System.out.println(e_con.getMessage());
                }
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