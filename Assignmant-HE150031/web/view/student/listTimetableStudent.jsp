<%-- 
    Document   : student
    Created on : Mar 11, 2022, 12:02:43 AM
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
        <c:forEach items="${requestScope.atten}" var = "c">
            ${c.getSche().getClss().getClassName()}
            ${c.getSche().getSub().getSubCode()}
            ${c.getDate()}
            ${c.getSlot().getSlotID()}
            ${c.getSlot().getSlotTime()}
            ${c.isAtten()}
            <br/>
        </c:forEach>
    </body>
</html>
