<%-- 
    Document   : questling2
    Created on : 2017/10/27, 11:38:06
    Author     : guest1Day
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
        <title>素因数分解</title>
    </head>
    <body>

        <%
                request.setCharacterEncoding("UTF-8");
               
                int num = Integer.parseInt(request.getParameter("num"));
                int num1 = num;
                
                out.print(num + "を素因数分解します。<br><br>");
                
                ArrayList<Integer> list = new ArrayList<Integer>();
               
                while(num > 1){
                    if(num%2 == 0){ 
                                               
                        list.add(2);
                        num=num/2;
                       
                    }else if(num%3 == 0){
                        
                        list.add(3);
                        num=num/3;
                        
                    }else if(num%5 == 0){
                        
                        list.add(5);
                        num=num/5;
                        
                    }else if(num%7 == 0){
                        
                        list.add(7);
                        num=num/7;
                        
                    }else{
                        break;
                    }
                }
                
                out.print("元の値：" + num1 + "<br>");
                out.print("素因数分解の結果：");
                
                 for(int i = 0; i < list.size(); i++){
                       
                       out.print(list.get(i));
                        
                       if(i < list.size() -1){
                           out.print("*");
                       }
                    }
                 
                 if(num != 1){
                     out.print("<br>余った値：" + num + "<br>");
                 }
                       
               
                
                        
        
                  
            
        %>
    </body>
</html>
