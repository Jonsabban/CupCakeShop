<%-- 
    Document   : storeFront
    Created on : 03-Mar-2017, 09:44:36
    Author     : Sanox
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello StoreFront!</h1>
        
        <a>You are logged in as <%= request.getParameter("username") %> </a>
    </body>
</html>
