<%-- 
    Document   : nyuuryoku2
    Created on : 2017/10/26, 13:39:43
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>入力フィールド</title>
    </head>
    <body>
        <form action="./hello.jsp" method="post">
            <div style="background-color:#EDF7FF;">
                <center>
            【氏名】<br>
            <input type="text" name="Name" size="30" maxlength="20"><br><br>
            
            【性別】<br>
            <input type="radio" name="Sex" value="男">男<br>
            
            <input type="radio" name="Sex" value="女">女<br><br>
            
            【趣味】<br>
            <textarea name="Hobby" cols="30" rows="10"></textarea><br><br>
            
            <input type="submit" name="btnSubmit" value="送信"><br><br>
            
               <img src="https://www.pakutaso.com/shared/img/thumb/tomsoiDSC08555_TP_V.jpg" alt="" border="0" />
               
                </center>
            </div>
        </form>
    </body> 
            
            
    
</html>
