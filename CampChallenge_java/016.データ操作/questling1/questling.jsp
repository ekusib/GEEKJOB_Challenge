<%-- 
    Document   : questling
    Created on : 2017/10/26, 17:19:12
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>  
    <head>
        <title>買い物</title>
    </head>
    <body>
        <form method="get" action="questling2.jsp">

             総額 <input type="number" name="total"><br><br>
             個数 <input type="number" name="count"><br><br>

            <input type="radio" name="type" value=1 checked="checked"> 雑貨<br>
            <input type="radio" name="type" value=2> 生鮮食品<br>
            <input type="radio" name="type" value=3> その他<br><br>
            
            <input type="submit" name="btnSubmit" value="送信">
            
        </form>
    </body>
</html>
