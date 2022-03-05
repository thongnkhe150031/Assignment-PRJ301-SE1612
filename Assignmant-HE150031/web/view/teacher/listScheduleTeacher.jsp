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
    </head>
    <body>
        
        <c:forEach items="${requestScope.listScheByTeacher}" var = "c">
            ${c.getClss().getClassName()} <br/>
        </c:forEach>
            
    </body>
</html>
