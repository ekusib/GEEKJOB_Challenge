<%-- 
    Document   : DB_sousa12_1
    Created on : 2017/11/08, 14:22:52
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>データ検索</title>
    </head>
    <body>
    <form action="./DB_sousa12_2" method="post">
    <center>
         
        『　氏名、年齢、生年月日からデータを検索します。』<br><br>
           
            -- 氏名を入力してください --<br>
        (※姓と名前の間に半角スペースを入れてください)--<br>
            (入力例：山田太郎 → 山田 太郎)<br>
            <input type="text" name="name" size="30"><br><br>
            
            -- 年齢を入力してください(半角) --<br>
            <input type="text" name="age" size="5"><br><br>
            
            -- 生年月日を入力してください(半角) --<br>
            (入力例：1991年6月7日 → 19910607)<br>
            <input type="text" name="birthday" size="30"><br><br>
            
            <input type="submit" name="btnSubmit" value="登録"><br><br>
            
                </center>
            
        </form>
    </body> 
            
            
    
</html>
