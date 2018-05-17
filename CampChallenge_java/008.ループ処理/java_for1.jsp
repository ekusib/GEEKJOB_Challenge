<%--
    Document   : java_for1　8の20乗を表示
    Created on : 2017/10/10, 14:46:31
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
          long a = 8;

          for(int i=0;i<20;i++){

        	  a *= 8;

          }

          out.println(a);

      %>
    </body>
</html>
