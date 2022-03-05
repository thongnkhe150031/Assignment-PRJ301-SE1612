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
    </head>
    <body>
        <h2>FPT University Academic Portal</h2>
        <h4>User Detail</h4>
        <table border="1">          
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
                    <td>${sessionScope.account.getName()}</td>
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

        
    </body>
</html>
