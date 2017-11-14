<%-- 
    Document   : DB_sousa13_kanri
    Created on : 2017/11/09, 16:58:23
    Author     : guest1Day
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>在庫管理ページ</title>
    </head>
    <body>
        
        <%
            String box = (String) session.getAttribute("check");
        
           if (box == "A") {
               
                out.print("処理に失敗しました。<br>");
        %><font color="red">※入力が必要な項目が入力されませんでした</font><br><br><%
                
            } else if (box == "B") {
                
                out.println("ログインに失敗しました。<br>");
        %><font color="red">※IDまたはパスワードが正しくありません</font><br><br><%

                
            }
        %>
        
        <form action="DB_sousa13_logout" method="post">
        <input type="submit" name="btnSubmit" value="ログアウト"><br><br><br>
        </form>  
        
        
        <form action="DB_sousa13_zaikoSEL" method="post">
    
        <br><br><input type="submit" name="shouhin_select" value="商品情報の一覧を表示する"><br><br><br>
            
        </form>    
        
    <form action="DB_sousa13_zaikoINS" method="post">
        
        <b> ------------------------新しく商品情報を登録します------------------------ </b><br><br>
           
            商品ID(半角) : <input type="text" name="shouhin_ID" size="5"><br><br>
            商品名 : <input type="text" name="shouhin_name" size="15"><br><br>
            在庫数(半角) : <input type="text" name="shouhin_number" size="10"><br><br>
              価格(半角)： <input type="text" name="shouhin_price" size="15"><br><br>
            
            <input type="submit" name="btnSubmit" value="登録"><br><br><br>
      
    </form>        
    
       
   
    </body>
</html>
