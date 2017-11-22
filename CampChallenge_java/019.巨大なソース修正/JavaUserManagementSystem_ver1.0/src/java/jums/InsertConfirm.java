package jums;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * insertconfirm.jspと対応するサーブレット
 * フォーム入力された情報はここでセッションに格納し、以降持ちまわることになる
 * 直接アクセスした場合はerror.jspに振り分け
 * @author hayashi-s
 */
public class InsertConfirm extends HttpServlet {

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
        try{
            HttpSession hs = request.getSession();
            //セッションに格納する文字コードをUTF-8に変更
            request.setCharacterEncoding("UTF-8");
            //直リンク防止
            String accesschk = request.getParameter("ac");
            if(accesschk == null || (Integer)hs.getAttribute("ac")!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }
            
            String name    = request.getParameter("name");
            String year    = request.getParameter("year");
            String month   = request.getParameter("month");
            String day     = request.getParameter("day");
            String type    = request.getParameter("type");
            String tell    = request.getParameter("tell");
            String comment = request.getParameter("comment");
            
            // UserDataBeansを利用し、取得した入力情報をudbsに格納
            UserDataBeans udbs = new UserDataBeans();
            
            udbs.setName(name);
            udbs.setYear(year);
            udbs.setMonth(month);
            udbs.setDay(day);
            udbs.setType(type);
            udbs.setTell(tell);
            udbs.setComment(comment);

            // 入力した情報をセッションに書き込み
            hs.setAttribute("udb", udbs);
           
            //直リンク防止用のランダムな数値を取得
            hs.setAttribute("ac", (int) (Math.random() * 1000));
        
            request.getRequestDispatcher("/insertconfirm.jsp").forward(request, response);
        }catch(Exception e){
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
