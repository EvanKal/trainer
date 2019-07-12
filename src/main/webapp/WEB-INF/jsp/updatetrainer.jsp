<%-- 
    Document   : updatetrainer
    Created on : Jun 11, 2019, 5:05:32 PM
    Author     : Los_e
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
           prefix="springForm"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Trainer</title>
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Schoolbell" rel="stylesheet">
    </head>
    <body>
        <p>Updating trainer with ID: ${trainer.trainerid}</p>
        <springForm:form method="Post" modelAttribute="trainer" action ="${pageContext.request.contextPath}/trainer/doupdatetrainer">
            <table>
                <tr>
                    <td>Trainer ID</td>
                    <td><springForm:input path="trainerid" disabled="true"/></td> 
                    <td><springForm:errors path="trainerid"/></td> 
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
                    <td><springForm:errors path="subject"/></td> 
                </tr>
            </table>
            <input type="hidden" id="user" name="traineridhidden" value="${trainer.trainerid}"/>
            <input type="submit">
        </springForm:form>
    </body>
</html>
