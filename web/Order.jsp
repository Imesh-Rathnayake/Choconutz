<%-- 
    Document   : Order
    Created on : Mar 27, 2024, 10:32:11 AM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
       <% 
    int number1 = Integer.parseInt(request.getParameter("cost"));
    int number2 = Integer.parseInt(request.getParameter("costH"));
       %>
       
       <h3> $<%= number1*15  %> </h3>
       <h3> $<%= number1*7  %> </h3>

    </body>
</html>
