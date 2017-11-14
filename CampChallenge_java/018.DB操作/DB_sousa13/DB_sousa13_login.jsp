<%-- 
    Document   : DB_sousa_login
    Created on : 2017/11/08, 15:54:58
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ログイン画面</title>
    </head>
    <body>
        <%
            String box = (String) session.getAttribute("check");
        
           if (box == "A") {
               
                out.print("ログインに失敗しました。<br>");
        %><font color="red">※IDまたはパスワードが入力されていません。</font><br><br><%
                
            } else if (box == "B") {
                
                out.println("ログインに失敗しました。<br>");
        %><font color="red">※IDまたはパスワードが正しくありません</font><br><br><%

                
            }
        %>
        
    <form action="DB_sousa13_login_session" method="post">
    <center>
         
        <br>【     ログイン     】<br><br>
               
            ------------------------------IDとパスワードを入力してください。------------------------------<br><br>
           
             ID(半角) : 
            <input type="text" name="Login_ID" size="15"><br><br>
            
             パスワード(半角) : 
            <input type="text" name="Login_Password" size="15"><br><br>
            
            <input type="submit" name="btnSubmit" value="ログイン"><br><br>
            
    </form>    
            
                </center>
            
        
    </body> 
            
            
    
</html>
