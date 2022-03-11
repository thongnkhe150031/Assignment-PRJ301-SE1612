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
        </style>
    </head>
    <body>
        <form class="form-compact" action="UpdateUser" method="post">
            <div class="row paddingBottom20">
                <div class="container col-4">
                    <div class="row">
                        <h6 class="text-center col-12 mb-0">Update Information</h6>
                        <sub class="text-right text-muted col-12"><a href="#" tabindex="-1"><i class="far fa-edit"></i></a></sub>
                    </div>
                    <div class="dropdown-divider mb-3"></div>
                    <div class="form-group row align-items-center">
                        <label for="email" class="col-4 col-form-label-sm text-right">Email:</label> 
                        <div class="col-8">
                            <div class="input-group"> 
                                <input id="email" value="${sessionScope.account.getEmail()} " type="text" class="form-control form-control-sm" readonly>
                            </div>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="fullName" class="col-4 col-form-label-sm text-right">Full Name:</label> 
                        <div class="col-8">
                            <div class="input-group"> 
                                <input id="fullName" value="${sessionScope.account.getName()}" name="fname" type="text" class="form-control form-control-sm" >
                            </div>
                        </div>
                    </div> 
                    <div class="form-group row align-items-center">
                        <label for="dateOfBirth" class="col-4 col-form-label-sm text-right">Date of Birth:</label> 
                        <div class="col-8">
                            <div class="input-group">
                                <input id="dateOfBirth" type="date" value="${sessionScope.account.getDob()}"  name="dob" class="form-control form-control-sm" >
                            </div>
                        </div>
                    </div>
                    <div class="form-group row align-items-center">
                        <label for="position" class="col-4 col-form-label-sm text-right">Majors</label> 
                        <div class="col-8">
                            <div class="input-group"> 
                                <select id="major" class="form-control" name ="major" >
                                    <c:forEach items="${requestScope.listMajors}" var = "c">
                                        <option value="${c.getMajorsID()}" <c:if test="${sessionScope.account.getMajor().getMajorsID() == c.getMajorsID()}">
                                                selected </c:if>
                                            >${c.getMajorsName()}</option>
                                    </c:forEach>
                                        
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group row align-items-center">
                        <label for="phoneNumber" class="col-4 col-form-label-sm text-right">Phone Number:</label> 
                        <div class="col-8">
                            <div class="input-group">
                                <input id="phoneNumber" type="text" value="${sessionScope.account.getPhone()}"  name="phone" class="form-control form-control-sm">
                            </div>
                        </div>
                    </div>

                    <div class="form-group row align-items-center">
                        <label for="address" class="col-4 col-form-label-sm text-right">Address:</label> 
                        <div class="col-8">
                            <div class="input-group">
                                <input id="address" type="text" value="${sessionScope.account.getAddress()}"  name="address" class="form-control form-control-sm" >
                            </div>
                        </div>
                    </div>
                    <div class="text-center">
                        <input id="submit" type="submit" value="Update">
                    </div>  

                </div>
            </div>
        </form>
    </body>
</html>
