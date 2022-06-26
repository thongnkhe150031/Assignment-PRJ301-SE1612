<%-- 
    Document   : UpdateUser
    Created on : Mar 7, 2022, 1:31:55 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <style>
            .extendable:focus {
                position: absolute;
                width: 110%;
                top: -1rem;
            }
            .home{
                position: absolute ;
                top: 10px;
                right: 32px;
                z-index: 999999;
                background-color: #fff;
                padding: 5px;
                background-color: light;
                border-radius: 5px;
            }  
        </style>
    </head>
    <body>
        <form class="form-compact" action="ChangePassword" method="post">
            <div class="row paddingBottom20">
                <div class="container col-4">
                    <div class="row">
                        <h6 class="text-center col-12 mb-0">Change Passwork
                            <div class="home">
                                <a href="Homepage${sessionScope.account.getRole().getRoleName()}">Home</a>
                            </div></h6>
                        <sub class="text-right text-muted col-12"><a href="#" tabindex="-1"><i class="far fa-edit"></i></a></sub>
                    </div>
                    <div class="dropdown-divider mb-3"></div>
                    <div class="form-group row align-items-center">
                        <label for="email" class="col-4 col-form-label-sm text-right">Email:</label> 
                        <div class="col-8">
                            <div class="input-group"> 
                                <input id="email" value="${sessionScope.account.getEmail()} " name="email" type="text" class="form-control form-control-sm" readonly>
                            </div>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="fullName" class="col-4 col-form-label-sm text-right">Old Password</label> 
                        <div class="col-8">
                            <div class="input-group"> 
                                <input id="fullName" name="opass" type="password" class="form-control form-control-sm" >
                            </div>
                        </div>
                    </div> 
                    <div class="form-group row align-items-center">
                        <label for="phoneNumber" class="col-4 col-form-label-sm text-right">New Password</label> 
                        <div class="col-8">
                            <div class="input-group">
                                <input id="phoneNumber" type="password"  name="npass" class="form-control form-control-sm">
                            </div>
                        </div>
                    </div>

                    <div class="form-group row align-items-center">
                        <label for="address" class="col-4 col-form-label-sm text-right">Confirm Password</label> 
                        <div class="col-8">
                            <div class="input-group">
                                <input id="address" type="password"  name="cpass" class="form-control form-control-sm" >
                            </div>
                        </div>
                    </div>
                    <div class="text-center">
                        <input id="submit" type="submit" value="Save">                      
                    </div>  
                    <div class="text-center">
                        <b>${mess}</b>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>
