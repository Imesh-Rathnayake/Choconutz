<%-- 
    Document   : test
    Created on : Apr 27, 2024, 11:52:28 PM
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
        

                    
        <p><center> <%int id =(Integer) request.getAttribute("message");  %><%=id%><center></p>
    </body>
</html>
