<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.UserDataBeans"%>

<%
    HttpSession hs = request.getSession();
    UserDataBeans udbs = (UserDataBeans) hs.getAttribute("udb");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
    <% if(!udbs.getName().equals("") && !udbs.getYear().equals("") && !udbs.getMonth().equals("") && !udbs.getDay().equals("")
            && udbs.getType() != null
            && !udbs.getTell().equals("") 
            && !udbs.getComment().equals("")){ %>
            
        <h1>登録確認</h1>
        名前:<%= udbs.getName()%><br>
        生年月日:<%= udbs.getYear() + "年" + udbs.getMonth() + "月" + udbs.getDay() + "日"%><br>
        種別:<%= udbs.getType()%><br>
        電話番号:<%= udbs.getTell()%><br>
        自己紹介:<%= udbs.getComment()%><br><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="submit" name="yes" value="はい">
        </form>
    <% }else { %>
        <h1>入力が不完全です</h1>
    <% } 
      if(udbs.getName().equals("")){%>
      <br><font color="red">※名前が未入力です。</font><%
}     if(udbs.getYear().equals("") || udbs.getMonth().equals("") || udbs.getDay().equals("")){%>
      <br><font color="red">※生年月日が未入力です。</font><%
}     if(udbs.getType() == null){%>
      <br><font color="red">※種別が未入力です。</font><%          
}     if(udbs.getTell().equals("")){%>
      <br><font color="red">※電話番号が未入力です。</font><%
}     if(udbs.getComment().equals("")){%>
      <br><font color="red">※自己紹介文が未入力です。</font><%
}%>
        <form action="insert" method="POST">
        <br> <input type="submit" name="no" value="登録画面に戻る">
        </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
