<%-- 
    Document   : listScheduleTeacher
    Created on : Mar 5, 2022, 10:20:07 PM
    Author     : Admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.Schedule"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
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
                font-family: 'Roboto', sans-serif;
            }
            .table-responsive {
                margin: 30px 0;
            }
            .table-wrapper {
                min-width: 1000px;
                background: #fff;
                padding: 20px;
                box-shadow: 0 1px 1px rgba(0,0,0,.05);
            }
            .table-title {
                padding-bottom: 10px;
                margin: 0 0 10px;
                min-width: 100%;
            }
            .table-title h2 {
                margin: 8px 0 0;
                font-size: 22px;
            }
            .search-box {
                position: relative;        
                float: right;
            }
            .search-box input {
                height: 34px;
                border-radius: 20px;
                padding-left: 35px;
                border-color: #ddd;
                box-shadow: none;
            }
            .search-box input:focus {
                border-color: #3FBAE4;
            }
            .search-box i {
                color: #a0a5b1;
                position: absolute;
                font-size: 19px;
                top: 8px;
                left: 10px;
            }
            table.table tr th, table.table tr td {
                border-color: #e9e9e9;
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
            table.table td:last-child {
                width: 130px;
            }
            table.table td a {
                color: #a0a5b1;
                display: inline-block;
                margin: 0 5px;
            }
            table.table td a.view {
                color: #03A9F4;
            }
            table.table td a.edit {
                color: #FFC107;
            }
            table.table td a.delete {
                color: #E34724;
            }
            table.table td i {
                font-size: 19px;
            }    
            .pagination {
                float: right;
                margin: 0 0 5px;
            }
            .pagination li a {
                border: none;
                font-size: 95%;
                width: 30px;
                height: 30px;
                color: #999;
                margin: 0 2px;
                line-height: 30px;
                border-radius: 30px !important;
                text-align: center;
                padding: 0;
            }
            .pagination li a:hover {
                color: #666;
            }	
            .pagination li.active a {
                background: #03A9F4;
            }
            .pagination li.active a:hover {        
                background: #0397d6;
            }
            .pagination li.disabled i {
                color: #ccc;
            }
            .pagination li i {
                font-size: 16px;
                padding-top: 6px
            }
            .hint-text {
                float: left;
                margin-top: 6px;
                font-size: 95%;
            }
            .submit{
                border-radius: 15px;

            }
            <%----%>

            .modal-confirm {
                color: #636363;
                width: 400px;
            }

            .modal-confirm .modal-content {
                padding: 20px;
                border-radius: 5px;
                border: none;
                text-align: center;
                font-size: 14px;
            }

            .modal-confirm .modal-header {
                border-bottom: none;
                position: relative;
            }

            .modal-confirm h4 {
                text-align: center;
                font-size: 26px;
                margin: 30px 0 -10px;
            }

            .modal-confirm .close {
                position: absolute;
                top: -5px;
                right: -2px;
            }

            .modal-confirm .modal-body {
                color: #999;
            }

            .modal-confirm .modal-footer {
                border: none;
                text-align: center;
                border-radius: 5px;
                font-size: 13px;
                padding: 10px 15px 25px;
            }

            .modal-confirm .modal-footer a {
                color: #999;
            }

            .modal-confirm .icon-box {
                width: 80px;
                height: 80px;
                margin: 0 auto;
                border-radius: 50%;
                z-index: 9;
                text-align: center;
                border: 3px solid #f15e5e;
            }

            .modal-confirm .icon-box i {
                color: #f15e5e;
                font-size: 46px;
                display: inline-block;
                margin-top: 13px;
            }

            .modal-confirm .btn,
            .modal-confirm .btn:active {
                color: #fff;
                border-radius: 4px;
                background: #60c7c1;
                text-decoration: none;
                transition: all 0.4s;
                line-height: normal;
                min-width: 120px;
                border: none;
                min-height: 40px;
                border-radius: 3px;
                margin: 0 5px;
            }

            .modal-confirm .btn-secondary {
                background: #c1c1c1;
            }

            .modal-confirm .btn-secondary:hover,
            .modal-confirm .btn-secondary:focus {
                background: #a8a8a8;
            }

            .modal-confirm .btn-danger {
                background: #f15e5e;
            }

            .modal-confirm .btn-danger:hover,
            .modal-confirm .btn-danger:focus {
                background: #ee3535;
            }

            .trigger-btn {
                display: inline-block;
                margin: 100px auto;
            }
            .home{
                position: absolute ;
                top: 15px;
                right: 32px;
                z-index: 999999;
                background-color: #fff;
            }  
            .home button{
                padding: 5px;
                background-color: light;
                border-radius: 5px;

            }

        </style>
    </head>
    <body>
        <div class="container-xl">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-8"><h2>View <b>Schedule</b></h2></div>
                            <div class="col-sm-4">
                                <div class="home">
                                    <a href="Homepage${sessionScope.account.getRole().getRoleName()}"><button>Home</button></a>
                                </div>
                                <!--                                <div class="search-box">
                                                                    <i class="material-icons">&#xE8B6;</i>
                                                                    <input type="text" class="form-control" placeholder="Search&hellip;">
                                                                </div>-->
                            </div>
                        </div>
                    </div>
                    <div>
                        <form action="ViewSchedule" method="post">
                            Choose: <select name="ClassID">
                                <c:forEach items="${requestScope.listScheByTeacher}" var = "c">
                                    <option value="${c.getClss().getClassID()}">${c.getClss().getClassName()}</option>
                                </c:forEach>
                            </select>
                            <input class ="submit " type="submit" value="submit">
                        </form>
                        <br/>
                    </div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Subject Code </th>
                                <th>Date</th>
                                <th>Slot </th>
                                <th>Time</th>
                                <th>Action</th>
                            </tr>
                        </thead>
               
                        <tbody>
                            <c:set var="i" value="0"></c:set>
                            <c:forEach items="${requestScope.timetableByTeacher}" var = "c">
                                <tr>
                                    <td>${i=i+1}</td>
                                    <td>${requestScope.classsID.getClassID()}</td>
                                    <td>${c.getDate()}</td>
                                    <td>${c.getSlot().getSlotID()}</td>
                                    <td>${c.getSlot().getSlotTime()}</td>  
                                    <td>
                                        <a href="viewMemberInClass?ClassID=${requestScope.classsID.getClassID()}" class="view" title="View" data-toggle="tooltip"><i class="material-icons">&#xE417;</i></a>                                      
                                        <a href="#myModal" class="delete" title="Delete" data-toggle="modal"><i class="material-icons">&#xE872;</i></a>
                                    </td>
                                </tr>
                                <!-- Modal HTML -->
                            <div id="myModal" class="modal fade">
                                <div class="modal-dialog modal-confirm">
                                    <div class="modal-content">
                                        <div class="modal-header flex-column">
                                            <div class="icon-box">
                                                <i class="material-icons">&#xE5CD;</i>
                                            </div>
                                            <h4 class="modal-title w-100">Are you sure?</h4>
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        </div>
                                        <div class="modal-body">
                                            <p>Do you really want to delete these records? This process cannot be undone.</p>
                                        </div>
                                        <div class="modal-footer justify-content-center">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                            <a href="DeleteSchedule?ClassID=${requestScope.classsID.getClassID()}&ScheID=${c.getSche()}&day=${c.getDate()}&SlotID=${c.getSlot().getSlotID()}"><button  type="button" class="btn btn-danger">Delete</button></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        </tbody>
                    </table>
                    <a href="InsertTimetable?clssID=${requestScope.classsID.getClassID()}">Insert</a>
                </div>
            </div>  
        </div>


    </body>

</body>
</html>
