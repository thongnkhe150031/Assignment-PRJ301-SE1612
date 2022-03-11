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
        <link rel="Stylesheet" href="../Content/bootstrap.css" type="text/css" /><link rel="Stylesheet" href="../Content/bootstrap.min.css" type="text/css" /><link rel="Stylesheet" href="../Content/bootstrap-theme.min.css" type="text/css" />
        <link rel="Stylesheet" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css" type="text/css" /><link rel="Stylesheet" href="../fu.css" type="text/css" /><link rel="Stylesheet" href="../JavaScript/jquery.css" type="text/css" /><link rel="Stylesheet" href="../JavaScript/jquery-ui.css" type="text/css" /><link rel="Stylesheet" href="../JavaScript/jquery.alerts.css" type="text/css" />

        <style type="text/css">
            .style1 {
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class = "row">
                <div class="col-md-8">
                    <h1><span>FPT Support Check Attendance</span></h1>  
                </div>

            </div>
            <div class="middle col-md-8">
                <h4>
                    <a href="">Home</a> <b>User Detail </b>
                </h4>
            </div>

            <div class = "col-md-8">
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
        </div>
    </body>
</html>
