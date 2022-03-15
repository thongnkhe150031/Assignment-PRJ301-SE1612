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
        <link rel="Stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css">
        <link rel="Stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="Stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js">
        <style type="text/css">
            * {
                margin: 0;
                padding: 0
            }

            body {
                background-color: #000
            }

            .card {
                width: 350px;
                background-color: #efefef;
                border: none;
                cursor: pointer;
                transition: all 0.5s
            }

            .image img {
                transition: all 0.5s
            }

            .card:hover .image img {
                transform: scale(1.5)
            }

            .btn {
                height: 140px;
                width: 140px;
                border-radius: 50%
            }

            .name {
                font-size: 22px;
                font-weight: bold
            }

            .idd {
                font-size: 14px;
                font-weight: 600
            }

            .idd1 {
                font-size: 12px
            }

            .number {
                font-size: 22px;
                font-weight: bold
            }

            .follow {
                font-size: 12px;
                font-weight: 500;
                color: #444444
            }

            .btn1 {
                height: 40px;
                width: 150px;
                border: none;
                background-color: #000;
                color: #aeaeae;
                font-size: 15px
            }

            .text span {
                font-size: 13px;
                color: #545454;
                font-weight: 500
            }

            .icons i {
                font-size: 19px
            }

            hr .new1 {
                border: 1px solid
            }

            .join {
                font-size: 14px;
                color: #a0a0a0;
                font-weight: bold
            }

            .date {
                background-color: #ccc
            }
        </style>
    </head>
    <body>
        <div>
            <div class="container mt-4 mb-4 p-3 d-flex justify-content-center">
                <div class="card p-4">
                    <div class=" image d-flex flex-column justify-content-center align-items-center"> <button class="btn btn-secondary"> <img src="https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.com%2Fpin%2F300404237646786897%2F&psig=AOvVaw3joJsaXcFtLTzeyhmm311S&ust=1647400964066000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCIiA8YCVx_YCFQAAAAAdAAAAABAJ" height="100" width="100" /></button> <span class="name mt-3">${sessionScope.account.getName()}</span> <span class="idd">@id${sessionScope.account.getUserID()}</span>
                        <div class="d-flex flex-row justify-content-center align-items-center gap-2"> <span class="idd1">${sessionScope.account.getEmail()}</span> <span><i class="fa fa-copy"></i></span> </div>
                        <div class="d-flex flex-row justify-content-center align-items-center mt-3"> <span class="number">1069 <span class="follow">Followers</span></span> </div>
                        <div class="d-flex flex-row justify-content-center align-items-center gap-2"<span class="idd1">${sessionScope.account.getPhone()}</span> <span><i class="fa fa-copy"></div>
                                    <div class="d-flex flex-row justify-content-center align-items-center gap-2"<span class="idd1">${sessionScope.account.getAddress()}</span> <span><i class="fa fa-copy"></div>
                                                <div class=" px-2 rounded mt-4 date "> <span class="join">DOB: ${sessionScope.account.getDob()}</span></div>
                                                <div class="UpdateUser"> <button class="btn1 btn-dark">Edit Profile</button> 
                                                </div>                               
                                                </div>
                                                </div>                                                                                                                                                                     
                                                </div>
                                                </div>


                                                </body>
                                                </html>
