<%-- 
    Document   : DB_sousa_9_1
    Created on : 2017/11/08, 10:31:46
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>データ登録</title>
    </head>
    <body>
    <form action="./DB_sousa9_2" method="post">
    <center>
         
        『　登録する情報を入力してください。』<br><br>
            
            【 ID 】(半角)<br>
            <input type="text" name="profilesID" size="5"><br><br>
            
            【 氏名 】<br>
            <input type="text" name="name" size="30"><br><br>
            
            【 電話番号 】(半角)<br>
            (入力例：080-1234-5678)<br>
            <input type="text" name="tell" size="30"><br><br>
            
            【 年齢 】(半角)<br>
            <input type="text" name="age" size="5"><br><br>
            
            【 生年月日 】(半角)<br>
            (入力例：1991年6月7日 → 19910607)<br>
            <input type="text" name="birthday" size="30"><br><br>
            
            <input type="submit" name="btnSubmit" value="登録"><br><br>
            
                </center>
            
        </form>
    </body> 
            
            
    
</html>
