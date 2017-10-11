<%-- 
    Document   : java_ for2
    Created on : 2017/10/10, 15:08:33
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
            String a = "A";
            
            for(int i=0;i<29;i++){
            
             a= a + "A" ;
                
            }
            
           out.print(a);
        %>
    </body>
</html>
