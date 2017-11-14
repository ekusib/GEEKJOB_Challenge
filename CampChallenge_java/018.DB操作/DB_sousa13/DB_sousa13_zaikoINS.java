/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guest1Day
 */
public class DB_sousa13_zaikoINS extends HttpServlet {

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
        
        String product_Insert = "INSERT INTO product(shouhin_ID,shouhin_name,shouhin_number,shouhin_price) VALUES(?,?,?,?)";
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "ekusib", "rvw29hcu");

            request.setCharacterEncoding("UTF-8");
            
            db_st = db_con.prepareStatement(product_Insert);
            
            int shouhin_ID = Integer.parseInt(request.getParameter("shouhin_ID"));
            String shouhin_name = request.getParameter("shouhin_name");
            int shouhin_number = Integer.parseInt(request.getParameter("shouhin_number"));
            int shouhin_price = Integer.parseInt(request.getParameter("shouhin_price"));
            
            db_st.setInt(1, shouhin_ID );
            db_st.setString(2, shouhin_name);
            db_st.setInt(3, shouhin_number);
            db_st.setInt(4, shouhin_price);

            int i = db_st.executeUpdate();

            out.print("--以下の情報が登録されました。--<br><br>");
            out.print("【 商品ID 】" + shouhin_ID);
            out.print("<br>【 商品名 】" + shouhin_name);
            out.print("<br>【 在庫数 】" + shouhin_number);
            out.print("<br>【 価格 】" + shouhin_price);
 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body>");
            out.println("<br><br><br><form action=\"DB_sousa13_kanri.jsp\" method=\"post\">");
            out.println("<input type=\"button\" value=\"在庫登録画面に戻る\" onClick=\"history.back()\"><br><br>");
            out.println("</body>");
            out.println("</html>");
            
            out.print("</center>");
            db_con.close();
            db_st.close();
            db_data.close();
            

        }catch (SQLException e_sql) {
            
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
