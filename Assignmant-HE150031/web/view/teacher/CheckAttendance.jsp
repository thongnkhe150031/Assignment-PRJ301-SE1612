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
        <title>JSP Page</title>
    </head>
    <body>
        <form action="CheckAttendance" method="post">
            <table border="1">
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
    </body>
</html>