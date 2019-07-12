<%-- 
    Document   : addtrainer
    Created on : Jun 10, 2019, 12:23:08 AM
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
        <title>Add trainer</title>
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Schoolbell" rel="stylesheet">
    </head>
    <body>
        <p>Add info for newly created trainer with ID: ${trainerid} and Username: ${username}</p>
        <springForm:form method="POST" modelAttribute="trainer" action ="${pageContext.request.contextPath}/trainer/doaddtrainer">
            <table>
                <tr>
                    <td>Trainer ID</td>
                    <td><springForm:input path="trainerid" disabled="true"/></td> 
                    <!--<td><springForm:errors path="trainerid"/></td>--> 
                </tr>
                <tr>
                    <td>First name</td>
                    <td><springForm:input path="firstname"/></td> 
                    <td><springForm:errors path="firstname"/></td> 
                </tr>
                <tr>
                    <td>Last name</td>
                    <td><springForm:input path="lastname"/></td> 
                    <td><springForm:errors path="lastname"/></td> 
                </tr>
                <tr>
                    <td>Subject</td>
                    <td><springForm:input path="subject"/></td> 
                    <!--<td><springForm:errors path="subject"/></td>--> 
                </tr>
            </table>
            <input type="hidden" id="user" name="traineridhidden" value="${trainerid}"/>
            <input type="hidden" id="user2" name="usernamehidden" value="${username}"/>
            <input type="submit">
        </springForm:form>
    </body>
</html>
