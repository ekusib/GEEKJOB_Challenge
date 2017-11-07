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
public class DB_sousa7 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
       //変数定義
        Connection db_con = null;
        PreparedStatement db_st_select = null;
        PreparedStatement db_st_update = null;
        ResultSet db_data = null;
       
        //sql文を定義
        String profiles_Update = "UPDATE profiles SET name = ?, age = ?, birthday = ? WHERE profilesID = ?";
        String profiles_Select = "SELECT * FROM profiles";
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            //JDBCドライバーをロード・DBへのコネクションを作成
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "ekusib", "rvw29hcu");
            
            //UPDATEのsql文を指定
            db_st_update = db_con.prepareStatement(profiles_Update);
            //UPDATEするパラメータの指定
            db_st_update.setString(1, "松岡 修造");
            db_st_update.setInt(2, 48);
            db_st_update.setInt(3, 19671106);
            db_st_update.setInt(4, 1);
            //UPDATEの実行
            int i = db_st_update.executeUpdate();
            //処理件数を表示
            System.out.print("処理件数：" + i);
            
            //SELECTのsql文を指定、取得
            db_st_select = db_con.prepareStatement(profiles_Select);
            db_data = db_st_select.executeQuery();
            
            out.print(" profilesID / name / tel /age / birthday<br><br>");
            
            //テーブルをすべて表示
            while(db_data.next()){
            
            out.println(db_data.getInt("profilesID") + " /");
            out.println(db_data.getString("name") + " /");
            out.println(db_data.getString("tel") + " /");
            out.println(db_data.getInt("age") + " /");
            out.println(db_data.getString("birthday"));
            out.println("<br>");
            
            }
            
            
            db_data.close();
            db_st_select.close();
            db_st_update.close();
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