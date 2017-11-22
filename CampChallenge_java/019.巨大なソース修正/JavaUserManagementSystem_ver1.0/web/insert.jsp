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
        <title>JUMS登録画面</title>
    </head>
    <body>
    
    <b>ユーザー情報を新規登録します。<br>
        「名前」、「生年月日」、「種別」、「電話番号」、「自己紹介文」を入力して確認画面へ進んでください。</b><br><br>
        
    <form action="insertconfirm" method="POST">
        名前(姓と名の間に半角スペースを入れてください)<br>
        <!--placeholderタグで、text欄に薄く文字を入力しておくことができる-->
        <input type="text" name="name" placeholder="入力例：佐藤 次郎" 
               value="<%if (udbs != null) {%><%= udbs.getName()%><% } %>">
        <br><br>

        生年月日<br>
        <select name="year">
            <option value="">----</option>
            <%
            for(int i=1950; i<=2010; i++){
                //文字列に変換
                String y = String.valueOf(i);
            %>
            
            <option value="<%=i%>"<%if (udbs != null && udbs.getYear().equals(y)) {%>
                        <%=Integer.parseInt(udbs.getYear())%> selected <% }%>> <%=i%> </option>
            <% } %>
        </select>年
        <select name="month">
            <option value="">--</option>
             <%
                for (int i = 1; i <= 12; i++) {
                //文字列に変換
                String m = String.valueOf(i);
             %>
                
                <option value="<%=i%>"
                <%if (udbs != null && udbs.getMonth().equals(m)) {%>
                <%=Integer.parseInt(udbs.getMonth())%> selected <% }%> ><%=i%></option>
                
                <% } %>
        </select>月
        <select name="day">
            <option value="">--</option>
            
             <%
                for (int i = 1; i <= 31; i++) {
                //文字列に変換
                String d = String.valueOf(i);
             %>
               <option value="<%=i%>"
               <%if (udbs != null && udbs.getDay().equals(d)) {%>
               <%=Integer.parseInt(udbs.getDay())%> selected <% }%> ><%=i%></option>
             <% }%>
        </select>日
        <br><br>

        種別
        <br>
        <!--udbs.getType()の中身が notNull かつ 1 のときエンジニア、notNull かつ 2 のとき営業、notNull かつ 3 のときその他を選択-->
            <input type="radio" name="type" value="1"
                   <%if (udbs != null && (udbs.getType() != null && udbs.getType().equals("1"))) {%> checked <%}%>>エンジニア<br>
            <input type="radio" name="type" value="2"
                   <%if (udbs != null && (udbs.getType() != null && udbs.getType().equals("2"))) {%> checked <%}%>>営業<br>
            <input type="radio" name="type" value="3"
                   <%if (udbs != null && (udbs.getType() != null && udbs.getType().equals("3"))) {%> checked <%}%>>その他<br>
            <br>

            電話番号(番号と番号の間にハイフン(-)を入れてください)<br>
        <input type="text" name="tell" placeholder="入力例：080-1234-5678" value="<%if (udbs != null) {%><%=udbs.getTell()%><% } %>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%if (udbs != null) {%><%=udbs.getComment()%><% }%></textarea><br><br>

        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
            <br>
            <%=JumsHelper.getInstance().home()%>
    </body>
</html>
