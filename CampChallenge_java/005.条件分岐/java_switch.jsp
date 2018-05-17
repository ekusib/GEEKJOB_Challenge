<%--
    Document   : java_switch　switch文での分岐
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

        // typeが1ならone,2ならtwo、それ以外なら想定外と表示

            int type = 1;

            switch(type){
                case 1:
                    out.print("one");
                    break;

                case 2:
                    out.print("two");
                    break;

                default:
                    out.print("想定外");
                    break;

            }
        %>
    </body>
</html>
