<%-- 
    Document   : InsertUser
    Created on : Mar 15, 2022, 11:36:50 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
        <title>Bootstrap Sign up Form Horizontal</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <style>
            body {
                color: #999;
                background: #f3f3f3;
                font-family: 'Roboto', sans-serif;
            }
            .form-control {
                border-color: #eee;
                min-height: 41px;
                box-shadow: none !important;
            }
            .form-control:focus {
                border-color: #5cd3b4;
            }
            .form-control, .btn {        
                border-radius: 3px;
            }
            .signup-form {
                width: 500px;
                margin: 0 auto;
                padding: 30px 0;
            }
            .signup-form h2 {
                color: #333;
                margin: 0 0 30px 0;
                display: inline-block;
                padding: 0 30px 10px 0;
                border-bottom: 3px solid #5cd3b4;
            }
            .signup-form form {
                color: #999;
                border-radius: 3px;
                margin-bottom: 15px;
                background: #fff;
                box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
                padding: 30px;
            }
            .signup-form .form-group row {
                margin-bottom: 20px;
            }
            .signup-form label {
                font-weight: normal;
                font-size: 14px;
                line-height: 2;
            }
            .signup-form input[type="checkbox"] {
                position: relative;
                top: 1px;
            }
            .signup-form .btn {        
                font-size: 16px;
                font-weight: bold;
                background: #5cd3b4;
                border: none;
                margin-top: 20px;
                min-width: 140px;
            }
            .signup-form .btn:hover, .signup-form .btn:focus {
                background: #41cba9;
                outline: none !important;
            }
            .signup-form a {
                color: #5cd3b4;
                text-decoration: underline;
            }
            .signup-form a:hover {
                text-decoration: none;
            }
            .signup-form form a {
                color: #5cd3b4;
                text-decoration: none;
            }	
            .signup-form form a:hover {
                text-decoration: underline;
            }
        </style>
    </head>
    <body>
        <div class="signup-form">
            <form action="InserUser" method="post" class="form-horizontal">
                <div class="row">
                    <div class="col-8 offset-4">
                        <h2>Insert User</h2>
                    </div>	
                </div>			
                <div class="form-group row">
                    <label class="col-form-label col-4">Full Name</label>
                    <div class="col-8">
                        <input type="text" class="form-control" name="name">
                    </div>        	
                </div>
                <div class="form-group row">
                    <label class="col-form-label col-4">Email</label>
                    <div class="col-8">
                        <input type="text" class="form-control" name="email">
                    </div>        	
                </div>
                <div class="form-group row">
                    <label class="col-form-label col-4">DOB</label>
                    <div class="col-8">
                        <input class="form-control" type="Date" name="dob">
                    </div>        	
                </div>
                <div class="form-group row">
                    <label  class="col-form-label col-4">Gender</label>
                    <div class="col-8">
                        <select class="form-control" name="gender">
                            <option value="true">Male</option>
                            <option value="false">Female</option>
                        </select>
                    </div>        	
                </div>
                <div class="form-group row">
                    <label  class="col-form-label col-4">Major</label>
                    <div class="col-8">
                        <select class="form-control" name="major">
                            <c:forEach items="${requestScope.listMajor1}" var="c">
                                <option value="${c.getMajorsID()}">${c.getMajorsName()}</option>
                            </c:forEach>
                        </select>
                    </div>        	
                </div>
                <div class="form-group row">
                    <label  class="col-form-label col-4">Role</label>
                    <div class="col-8">
                        <select class="form-control" name="role">
                            <c:forEach items="${requestScope.listRole1}" var="c">
                                <option value="${c.getRoleID()}">${c.getRoleName()}</option>
                            </c:forEach>
                        </select>
                    </div>        	
                </div>
                <div class="form-group row">
                    <label class="col-form-label col-4">Phone</label>
                    <div class="col-8">
                        <input class="form-control" type="text" name="phone">
                    </div>        	
                </div>
                <div class="form-group row">
                    <label  class="col-form-label col-4">Address</label>
                    <div class="col-8">
                        <td><input class="form-control" type="text" name="address"></td>
                    </div>        	
                </div>
                <div class="form-group row">
                    <div class="col-8 offset-4">
                        <button type="submit" class="btn btn-primary btn-lg">Insert</button>
                    </div>  
                </div>		      
            </form>
        </div>
    </body>
</html>
