<%-- 
    Document   : java_switch2
    Created on : 2017/10/10, 13:06:29
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
            char a = 'A';
            
            switch(a){
                case 'A':
                    out.print("英語");
                    break;
                    
                case 'あ':
                    out.print("日本語");
                    break;
                    
                default:
                    out.print("");
                    break;
                    
            }
        %>
    </body>
</html>
