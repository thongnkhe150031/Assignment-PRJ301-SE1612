<%-- 
    Document   : CheckAttendance
    Created on : Mar 13, 2022, 11:03:43 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Attendance</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <style>
            body {
                color: #566787;
                background: #f5f5f5;
                font-family: 'Varela Round', sans-serif;
                font-size: 13px;
            }
            .table-responsive {
                margin: 30px 0;
            }
            .table-wrapper {
                background: #fff;
                padding: 20px 25px;
                border-radius: 3px;
                min-width: 1000px;
                box-shadow: 0 1px 1px rgba(0,0,0,.05);
            }
            .table-title {        
                padding-bottom: 15px;
                background: #435d7d;
                color: #fff;
                padding: 16px 30px;
                min-width: 100%;
                margin: -20px -25px 10px;
                border-radius: 3px 3px 0 0;
            }
            .table-title h2 {
                margin: 5px 0 0;
                font-size: 24px;
            }
            .table-title .btn-group {
                float: right;
            }
            .table-title .btn {
                color: #fff;
                float: right;
                font-size: 13px;
                border: none;
                min-width: 50px;
                border-radius: 2px;
                border: none;
                outline: none !important;
                margin-left: 10px;
            }
            .table-title .btn i {
                float: left;
                font-size: 21px;
                margin-right: 5px;
            }
            .table-title .btn span {
                float: left;
                margin-top: 2px;
            }
            table.table tr th, table.table tr td {
                border-color: #e9e9e9;
                padding: 12px 15px;
                vertical-align: middle;
            }
            table.table tr th:first-child {
                width: 60px;
            }
            table.table tr th:last-child {
                width: 100px;
            }
            table.table-striped tbody tr:nth-of-type(odd) {
                background-color: #fcfcfc;
            }
            table.table-striped.table-hover tbody tr:hover {
                background: #f5f5f5;
            }
            table.table th i {
                font-size: 13px;
                margin: 0 5px;
                cursor: pointer;
            }	
            table.table td:last-child i {
                opacity: 0.9;
                font-size: 22px;
                margin: 0 5px;
            }
            table.table td a {
                font-weight: bold;
                color: #566787;
                display: inline-block;
                text-decoration: none;
                outline: none !important;
            }
            table.table td a:hover {
                color: #2196F3;
            }
            table.table td a.edit {
                color: #FFC107;
            }
            table.table td a.delete {
                color: #F44336;
            }
            table.table td i {
                font-size: 19px;
            }
            table.table .avatar {
                border-radius: 50%;
                vertical-align: middle;
                margin-right: 10px;
            }
            .pagination {
                float: right;
                margin: 0 0 5px;
            }  
            .note{
                text-align: center
            }
            .absent{
                color: red;
            }
            .atten{
                color: green
            }
        </style>
    </head>
    <body>
        <div class="container-xl">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-6">
                                <h2>View <b>Attendace</b></h2>
                            </div>
                        </div>
                    </div>
                    <form action="CheckAttendance" method="post">
                        <table class="table table-striped table-hover">
                            <thead>
                                <tr>
                                    <th></th>
                                    <th>Class</th>
                                    <th>Full Name</th>
                                    <th>Attendance</th>
                                    <th>Note</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:set var="i" value="0"></c:set>
                                <c:forEach items="${requestScope.listAtten}" var="c">
                                    <tr>
                                        <td>${i=i+1} <input type="hidden" value="${c.getSlot().getSlotID()}" name="slotID"></td>
                                        <td>${c.getSche().getClss().getClassName()} <input type="hidden" value="${c.getSche().getScheID()}" name="scheID"> </td>
                                        <td>${c.getStudenName()} <input type="hidden" value="${c.getDate()}" name="day"></td>
                                        <td><input ${c.isAtten() == true?"checked":""} type="radio" value="true" name="present${c.getUserID()}">attended
                                            <input ${c.isAtten() == false?"checked":""}  type="radio" value="false" name="present${c.getUserID()}">absent</td>
                                        <td><input type="text" value="${c.getNote()}" name="note${c.getUserID()}"></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <input type="submit" value="Save">
                    </form>
                </div>
            </div>        
        </div>
    </div>
</body>
