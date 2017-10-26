<%-- 
    Document   : hello
    Created on : 2017/10/26, 13:57:20
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            //受け取る情報の文字コードを指定
            request.setCharacterEncoding("UTF-8");
            //テキストボックス（氏名）の情報を表示
            out.print("【氏名】<br>" + request.getParameter("Name") + "<br><br>");
            //ラジオボタン（性別）の情報を表示
            out.print("【性別】<br>" + request.getParameter("Sex") + "<br><br>");
            //テキストエリア（趣味）の情報を表示
            out.print("【趣味】<br>" + request.getParameter("Hobby") + "<br>");
            %>
    </body>
</html>
