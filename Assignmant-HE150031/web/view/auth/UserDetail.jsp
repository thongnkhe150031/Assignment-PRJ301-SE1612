<%-- 
    Document   : UserDetail
    Created on : Mar 5, 2022, 10:04:55 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/userdetail.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    </head>
    <body>
        <div class="full_body">
            <h2>FPT Support Check Attendance</h2>
            <div id="header">
                <h4>
                    <a href="">Home</a> User Detail 
                </h4>
            </div>
            <table border="0">          
                <tr>
                    <td>UserID: </td>
                    <td>${sessionScope.account.getUserID()}</td>
                </tr>
                <tr>
                    <td>Email: </td>
                    <td>${sessionScope.account.getEmail()}</td>
                </tr>
                <tr>
                    <td>Full Name: </td>
                    <td>${sessionScope.account.getName() }</i></td>
                </tr>
                <tr>
                    <td>Gender: </td>
                    <td>${sessionScope.account.isGender()}</td>
                </tr>
                <tr>
                    <td>Phone number: </td>
                    <td>${sessionScope.account.getPhone()}</td>
                </tr>
                <tr>
                    <td>Date of Birth: </td>
                    <td>${sessionScope.account.getDob()}</td>
                </tr>
                <tr>
                    <td>Address: </td>
                    <td>${sessionScope.account.getAddress()}</td>
                </tr>

                <tr>
                    <td>Majors: </td>
                    <td>${sessionScope.account.getMajor().getMajorsName()}</td>
                </tr>
                <tr>
                    <td>Role: </td>
                    <td>${sessionScope.account.getRole().getRoleName()}</td>
                </tr> 
            </table>
            <a href="UpdateUser"><button>Update</button></a>
        </div>
    </body>
</html>
