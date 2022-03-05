<%-- 
    Document   : login
    Created on : Feb 3, 2022, 9:12:30 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../../css/login.css" type="text/css">
    </head>
    <body>
   <h1>FPT University Academic Portal</h1>
    <div class="full_body">
        <div class="image">
            <image src="../../img/Logo_Đại_học_FPT.png" alt="logo-fpt" />
        </div>
        <form action="../../login" method="POST">
            <div class="main">
                <table>
                    <tr>
                        <td> Username </td>
                        <td><input type="text" name="email"> </td>
                    </tr>
                    <tr>
                        <td>Password </td>
                        <td><input type="password" name="password"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="checkbox" name="remember" value="remember" /> Remember Me. </td>                       
                    </tr>
                </table>             
                <input type="submit" value="Login">    
            </div>
        </form>
    </div>
    </body>
</html>
