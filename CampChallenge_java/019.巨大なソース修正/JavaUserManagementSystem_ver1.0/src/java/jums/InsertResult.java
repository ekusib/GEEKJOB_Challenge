package jums;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * insertresultと対応するサーブレット
 * フォームから入力された値をセッション経由で受け取り、データベースにinsertする
 * 直接アクセスした場合はerror.jspに振り分け
 * @author hayashi-s
 */
public class InsertResult extends HttpServlet {

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
        
        
        HttpSession hs = request.getSession();
        UserDataBeans udbs = (UserDataBeans) hs.getAttribute("udb");
        //セッションに格納する文字コードをUTF-8に変更
        request.setCharacterEncoding("UTF-8");
        
        try{
           //直リンク防止
        String accesschk = request.getParameter("ac");
        if(accesschk ==null || (Integer)hs.getAttribute("ac")!=Integer.parseInt(accesschk)){
            throw new Exception("不正なアクセスです");
        }
        
            
             // UserDataDTOを利用して取得した入力情報をuser_dataに格納
            UserDataDTO user_data = new UserDataDTO();

            user_data.setName(udbs.getName());
            // 生年月日Date型に変換
            //SimpleDateFormatの作成
            // 生年月日をparseで日付に変換・Date型のbirthdayに代入
            // DTOのsetBirthday()メソッドを利用して、user_dataにセット
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date birthday = sdf.parse(udbs.getYear() + "-" + udbs.getMonth() + "-" + udbs.getDay());
            user_data.setBirthday(birthday);
            // 種別をint型に変換・DTOのsetType()メソッドを利用して、user_dataにセット
            user_data.setType(Integer.parseInt(udbs.getType()));
            user_data.setTell(udbs.getTell());
            user_data.setComment(udbs.getComment());

            // DBへデータの挿入
            UserDataDAO.getInstance().insert(user_data);

            request.getRequestDispatcher("/insertresult.jsp").forward(request, response);
        }catch(Exception e){
            //データ挿入に失敗したらエラーページにエラー文を渡して表示
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
