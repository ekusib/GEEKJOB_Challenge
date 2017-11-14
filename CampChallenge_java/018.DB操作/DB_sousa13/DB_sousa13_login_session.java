/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guest1Day
 */
public class DB_sousa13_login_session extends HttpServlet {

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
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            Class.forName("com.mysql.jdbc.Driver");
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "ekusib", "rvw29hcu"); 
            
            RequestDispatcher rd1 = request.getRequestDispatcher("/DB_sousa13_login.jsp");
            RequestDispatcher rd2 = request.getRequestDispatcher("/DB_sousa13_kanri.jsp");
            
            HttpSession session = request.getSession();
            session.setAttribute("check", null);
            
           
            String id = request.getParameter("Login_ID");
            String password= request.getParameter("Login_Password");


            if (id.equals("") || password.equals("")) {
                
                session.setAttribute("check", "A");
                rd1.forward(request, response);

            }else{
                
                db_st = db_con.prepareStatement("SELECT * FROM user_profiles WHERE loginID = ? AND password = ?");
                
                db_st.setString(1, id);
                db_st.setString(2, password);

                db_data = db_st.executeQuery();

                boolean tf = false;

                while (db_data.next()) {
                    
                    tf = true;
                    session.setAttribute("check", request.getParameter("id"));  
                    rd2.forward(request, response);
                }
                
                if (tf == false) {
                    session.setAttribute("check", "B");
                    rd1.forward(request, response);
                }
            }

            db_con.close();
            db_st.close();
            db_data.close();
            
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
