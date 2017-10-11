<%-- 
    Document   : java_while
    Created on : 2017/10/10, 15:50:11
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
          int a = 1000;
          
          while(a > 100){
            
              out.println(a);
              
              a = a/2;
          }
      %>
    </body>
</html>
