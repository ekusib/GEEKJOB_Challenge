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
public class DB_sousa12_2 extends HttpServlet {

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
        
        String profiles_Select = "SELECT * FROM profiles WHERE name LIKE ? AND age = ? AND birthday = ?";
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "ekusib", "rvw29hcu");

            request.setCharacterEncoding("UTF-8");
            
            db_st = db_con.prepareStatement(profiles_Select);
            
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            int birthday = Integer.parseInt(request.getParameter("birthday"));
            
            db_st.setString(1, "%" + name + "%");
            db_st.setInt(2, age);
            db_st.setInt(3, birthday);

            out.print("<br>【氏名】 " + name);
            out.print("<br>【年齢】 " + age);
            out.print("<br>【生年月日】 " + birthday);
            out.print("<br><br>--以上の入力内容から情報が検索されました。--<br><br>");
            
            db_data = db_st.executeQuery();
            
            out.print("--検索結果--<br><br>");
            
            while(db_data.next()){
            
            out.println("ID : " + db_data.getInt("profilesID"));
            out.println("<br>氏名 ： " + db_data.getString("name"));
            out.println("<br>電話番号 : " + db_data.getString("tel"));
            out.println("<br>年齢 ： " + db_data.getInt("age"));
            out.println("<br>生年月日 : " + db_data.getString("birthday"));
            out.println("<br>");
            
            }
            
        
            
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
