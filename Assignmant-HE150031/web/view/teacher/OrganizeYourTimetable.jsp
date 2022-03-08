<%-- 
    Document   : OrganizeYourTimetable
    Created on : Mar 8, 2022, 9:10:00 PM
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
            <tr>
                <th>Class: </th>
                <th><input type="text" readonly></th>
            </tr>
            <tr>
                <th>Subject: </th>
                <th><input type="text" readonly></th>
            </tr>
            <tr>
                <th>Date: </th>
                <th><input type="Date" name="Ordate"></th>
            </tr>
            <tr>
                <td>Slot: </td>
                <td><input type="number" name="OrSlot"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="Submit" value="Submit"></td>
            </tr>
        </table>
    </body>
</html>
