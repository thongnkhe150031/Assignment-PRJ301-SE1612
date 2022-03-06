<%-- 
    Document   : memInClass
    Created on : Mar 6, 2022, 5:15:48 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        ${i = 0} //can sua
    </head>
    <body>
        <table border="1"> 
            <c:forEach items="${requestScope.userInClass}" var = "c">
                <tr>
                    <td>${i = i+1}</td>
                    <td>${c.getUserID()}</td>
                    <td>${c.getName()}</td>
                    <td>${c.getEmail()}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
