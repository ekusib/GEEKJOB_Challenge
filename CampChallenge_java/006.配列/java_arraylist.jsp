<%-- 
    Document   : java_arraylist
    Created on : 2017/10/10, 13:32:58
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
        <%@page import="java.util.ArrayList"%>
        <%
            ArrayList<String> datas = new ArrayList<String>();
            
            datas.add("10");
            datas.add("100");
            datas.add("soeda");
            datas.add("hayashi");
            datas.add("-20");
            datas.add("118");
            datas.add("END");
            
           String data = datas.get(6);
            out.print(data);
        %>
    </body>
</html>
