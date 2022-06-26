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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <style>
            .login-form {
                width: 340px;
                margin: 50px auto;
                font-size: 15px;
            }
            .login-form form {
                margin-bottom: 15px;
                background: #f7f7f7;
                box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
                padding: 30px;
            }
            .login-form h2 {
                margin: 0 0 15px;
            }
            .form-control, .btn {
                min-height: 38px;
                border-radius: 2px;
            }
            .btn {        
                font-size: 15px;
                font-weight: bold;
            }
            body{
                background-image: url('img/hcm.png ');
                background-repeat: no-repeat;
                background-size: 100%;
            }
        </style>
        /<%--<link rel="stylesheet" href="css/login.css" type="text/css">--%>
    </head>
    <body>
        <div class="text-center">
            <h1><span>FPT Support Check Attendance</span></h1>
        </div>
        <div class="login-form">
            <form action="login" method="post">
                <h2 class="text-center">Log in</h2>
                <h6 class="text-center">
                    ${mess}
                </h6>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Username" required="required" name="email">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="Password" required="required" name="password" >
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">Log in</button>
                </div>
                <div class="clearfix">
                    <label class="float-left form-check-label"><input type="checkbox" name="remember"> Remember me</label>
                    <a href="#" class="float-right">Forgot Password?</a>
                </div>        
            </form>
            <p class="text-center"><a href="#">Create an Account</a></p>
        </div>
    </body>
</html>
