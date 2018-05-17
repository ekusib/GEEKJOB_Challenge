<%--
    Document   : java_enzan　変数と定数の演算
    Created on : 2017/10/10, 11:25:33
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            final int base = 30;
            int num = 4;

            int tasu = base + num;
            int hiku = base - num;
            int kakeru = base * num;
            int waru = base / num;
            int amari = base % num;

            out.print(tasu);
            out.print(hiku);
            out.print(kakeru);
            out.print(waru);
            out.print(amari);
        %>
    </body>
</html>
