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
public class DB_sousa9_2 extends HttpServlet {

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
        
        String profiles_Insert = "INSERT INTO profiles(profilesID,name,tel,age,birthday) VALUES(?,?,?,?,?)";
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "ekusib", "rvw29hcu");

            request.setCharacterEncoding("UTF-8");
            
            db_st = db_con.prepareStatement(profiles_Insert);
            
            int profilesID = Integer.parseInt(request.getParameter("profilesID"));
            String name = request.getParameter("name");
            String tell = request.getParameter("tell");
            int age = Integer.parseInt(request.getParameter("age"));
            int birthday = Integer.parseInt(request.getParameter("birthday"));
            
            db_st.setInt(1, profilesID );
            db_st.setString(2, name);
            db_st.setString(3, tell);
            db_st.setInt(4, age);
            db_st.setInt(5, birthday);

            int i = db_st.executeUpdate();

            out.print("--以下の情報が登録されました。--<br><br>");
            out.print("【 ID 】" + profilesID);
            out.print("<br>【氏名】" + name);
            out.print("<br>【電話番号】" + tell);
            out.print("<br>【年齢】" + age);
            out.print("<br>【生年月日】" + birthday);
            
            db_data.close();
            db_st.close();
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
