<%-- 
    Document   : TimetableClass
    Created on : Mar 9, 2022, 3:09:24 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th></th>
                    <th>Subject Code: </th>
                    <th>Date: </th>
                    <th>Slot: </th>
                    <th>Time: </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.timetableByTeacher}" var = "c">
                    <tr>
                        <td></td>
                        <td>${c.getSubCode()}</td>
                        <td>${c.getDate()}</td>
                        <td>${c.getSlot().getSlotID()}</td>
                        <td>${c.getSlot().getSlotTime()}</td>    
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="InsertTimetable">Insert</a>
    </body>
</html>
