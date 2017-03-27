<%-- 
    Document   : index
    Created on : 02-Mar-2017, 14:45:16
    Author     : Sanox
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="login.css">
        <title>LoginPage</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>

        <div>
            <form action="BusinessLogic" method="post">
                <label for="Username">Enter username:</label>
                <input type="text" id="Username" name="username" placeholder="Username">
                <label for="Password">Enter password:</label>
                <input type="password" id="Password" name="password" placeholder="Password">
                <input type="hidden" name="action" value="login">
                <input type="submit" value="Submit">

                <a href="registerUser.html">Don't have a login? Click here to register!</a>
            </form>

        </div>

    </body>
</html>
