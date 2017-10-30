<%-- 
    Document   : Session2
    Created on : 2017/10/30, 14:11:54
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

 <%
           request.setCharacterEncoding("UTF-8");
           
           HttpSession hs= request.getSession();
           
           hs.setAttribute("name",request.getParameter("name"));
           hs.setAttribute("sex",request.getParameter("sex"));
           hs.setAttribute("hobby",request.getParameter("hobby"));
           
           String username=(String)hs.getAttribute("name");
           String usersex=(String)hs.getAttribute("sex");
           String userhobby=(String)hs.getAttribute("hobby");
           
           String check1="";
           String check2="";
          
           if(hs.getAttribute("sex")!=null){
               if(hs.getAttribute("sex").equals("男")){
                   check1="checked";
               }
               if(hs.getAttribute("sex").equals("女")){
                   check2="checked";
               }
               
           }
       
        %>        
         
 <form action="Session.jsp">
     
            名前<br>
            <input type="text" name="name" value=<% 
                
                if(username != null){
                    
                       out.print(username);
                       
                      }%>><br><br>
            
            
            性別<br>
            <input type="radio" name="sex" value="男" <%=check1%>>男
            <input type="radio" name="sex" value="女" <%=check2%>>女<br><br>
            
            趣味<br>
            <textarea name="hobby" cols="30" rows="10"><%
                
                if(userhobby!=null){
                    
                    out.print(userhobby);
                
                }%></textarea><br><br>
                
            <input type="submit" name="btnsubmit" value="送信">

        </form>
    </body>
</html>