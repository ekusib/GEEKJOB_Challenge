<%--
    Document   : java_hashmap　HashMapへの格納と取得
    Created on : 2017/10/10, 14:15:16
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
    <%@page import="java.util.HashMap"%>
    <%
    HashMap<String,String> datas = new HashMap<String,String>();

    datas.put("1","AAA");

    datas.put("hello","world");

    datas.put("soeda","33");

    datas.put("20", "20");

   out.print(datas.get("hello"));
    %>
    </body>
</html>
