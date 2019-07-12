<%-- 
    Document   : adduser
    Created on : Jun 11, 2019, 1:40:05 AM
    Author     : Los_e
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
           prefix="springForm"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add User</title>
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Schoolbell" rel="stylesheet">
    </head>
    <body>
        <%--<c:import url="/"/>--%>
        <p>First create user account for the new trainer</p>
        <springForm:form method="Post" modelAttribute="user" action ="${pageContext.request.contextPath}/user/doadduser">
            <table>
                <tr>
                    <td>Username</td> 
                    <td><springForm:input path="username"/></td> 
                    <td><springForm:errors path="username"/></td> 

                </tr>
                <tr>
                    <td>Password</td>
                    <td><springForm:input path="password"/></td> 
                    <!--<td><springForm:errors path="password"/></td>--> 
                </tr>
            </table>
            <input type="submit">
        </springForm:form>
    </body>
</html>
