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
        <link rel="stylesheet" href="css/login.css">
    </head>
    <body>
   <h1>FPT University Academic Portal</h1>
    <div class="full_body">
        <div class="image">
            <image src="img/Logo_Đại_học_FPT.png" alt="logo-fpt" />
        </div>
        <form action="" method="post">
            <div class="main">
                <table>
                    <tr>
                        <td> Username </td>
                        <td><input type="text" name="username"> </td>
                    </tr>
                    <tr>
                        <td>Password </td>
                        <td><input type="text" name="username"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td> <select name="condition">
                                <option value="1">Student</option>
                                <option value="2">Teacher</option>
                                <option value="3">Parents</option>
                            </select><br /></td>
                    </tr>
                </table>
                <input type="submit" value="Log In">
                <input type="checkbox" name="remember" value="remember" /> Remember Me.
            </div>
        </form>
    </div>
    </body>
</html>
