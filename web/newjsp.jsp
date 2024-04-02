<%-- 
    Document   : newjsp
    Created on : Mar 27, 2024, 9:22:08 AM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>  <%-- add the all java class by this  --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%=(int)(Math.random()*100)%><br>    
        <%=new java.util.Date()%>  <%-- This use for if you do not add java class --%>
        <%=new Date() %>            <%-- above when you  add java class --%>
        <br>
        
        
        <%--  how to call the method,(using expression tag 
                <%=fun() %>                          --%>
        
        
        <% int count = 0; %>
        Number of visit to my page using Scriptlets tag <%= ++count %> <br>
        
        <%! int visit = 0; %>
        Number of visit to my page declaration tag <%= ++visit %>
        
        
        <%--  Display squrroot --%>
        
        
        
        
        
        
        <%--  this use for include another file into this page  --%> 
      <%@include file="login.html" %>
        
    </body>
</html>
