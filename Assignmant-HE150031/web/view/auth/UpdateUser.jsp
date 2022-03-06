<%-- 
    Document   : UpdateUser
    Created on : Mar 7, 2022, 1:31:55 AM
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
        <form action="UpdateUser" method="get">
            <table>
                <tr>
                    <td>UserID: </td>
                    <td><input type="text" value="${sessionScope.account.getUserID()} " readonly></td>
                </tr>
                 <tr>
                    <td>Full Name: </td>
                    <td><input type="text" value="${sessionScope.account.getName()}" name="fname"></td>
                </tr>
                 <tr>
                    <td>Email: </td>
                    <td><input type="text" value="${sessionScope.account.getEmail()} " readonly></td>
                </tr>
                 <tr>
                    <td>Phone number: </td>
                    <td><input type="text" value="${sessionScope.account.getPhone()}"  name="phone"></td>
                </tr>
                 <tr>
                    <td>Date of Birth: </td>
                    <td><input type="date" value="${sessionScope.account.getDob()}"  name="dob"></td>
                </tr>
                 <tr>
                    <td>Address: </td>
                    <td><input type="text" value="${sessionScope.account.getDob()}"  name="address"></td>
                </tr>
                 <tr>
                    <td></td>
                    <td><input type = "submit" value ="Update" ></td>
                </tr>
                
            </table>
                
        </form>
    </body>
</html>
