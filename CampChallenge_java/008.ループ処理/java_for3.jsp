<%--
    Document   : java_for3　1～100を足して結果を表示
    Created on : 2017/10/10, 15:34:30
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
           int a = 0;

           for(int i=0;i<=100;i++){

               a = a + i;

           }

            out.print(a);

       %>
    </body>
</html>
