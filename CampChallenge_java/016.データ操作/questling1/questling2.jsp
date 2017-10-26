<%-- 
    Document   : questling2
    Created on : 2017/10/26, 17:32:01
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
                request.setCharacterEncoding("UTF-8");
               
                int total = Integer.parseInt(request.getParameter("total"));
                int count = Integer.parseInt(request.getParameter("count"));
                int type = Integer.parseInt(request.getParameter("type"));
              
                switch (type) {
                case 1:
                    out.print("【雑貨】の商品を購入しました。<br>");
                    break;
                case 2:
                    out.print("【生鮮食品】の商品を購入しました。<br>");
                    break;
                case 3:
                    out.print("【その他】の商品を購入しました。<br>");
                    break;
            }
                
                out.print("合計で" + total + "円です。<br>1つ当たり" + (total / count) + "円です。<br>");
               
                if (total >= 5000) {
                    
                    int point = (int)(total * 0.05);
                    out.print(point+ "ポイント付与されました。");
                    
                } else if (total >= 3000) {
                    
                    int point = (int) (total * 0.04);
                    out.print(point + "ポイント付与されました。");
                    
                } else {
                    out.print("3000以上お買い上げでポイントが付与されます。");
                }
            
        %>
    </body>
</html>