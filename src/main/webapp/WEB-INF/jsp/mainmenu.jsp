<%-- 
    Document   : mainmenu
    Created on : Jun 9, 2019, 10:23:46 PM
    Author     : Los_e
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD on trainers</title>
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Schoolbell" rel="stylesheet">
    </head>
    <body>
        <c:if test="${success == 1}">
            <div>
                <p>Successfully deleted trainer with id ${deletedtrainerid}</p>
            </div>
        </c:if>
        <c:if test="${success == 0}">
            <div>
                <p>Error. Trainer with id ${deletedtrainerid} could not be deleted</p>
            </div>
        </c:if>
        <c:if test="${successupdate == 1}">
            <div>
                <p>Successfully updated trainer with id ${updatedtrainerid}</p>
            </div>
        </c:if>
        <c:if test="${successupdate == 0}">
            <div>
                <p>Error. Trainer with id ${updatedtrainerid} could not be updated</p>
            </div>
        </c:if>

        <c:choose>
            <c:when test = "${trainerslist.size() == 0}">
                <p>No results. Currently no trainers</p>
            </c:when>

            <c:when test = "${trainerslist.size() > 0}">
                <table>
                    <thead>
                        <tr>
                            <td >ID</td>
                            <td>First Name</td>
                            <td>Last Name</td>
                            <td>Subject</td>
                            <td>Update</td>
                            <td>Delete</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${trainerslist}" var="trainer">
                            <tr>
                                <td>${trainer.trainerid}</td>
                                <td>${trainer.firstname}</td>
                                <td>${trainer.lastname}</td>
                                <td>${trainer.subject}</td>
                                <td><a href="${pageContext.request.contextPath}/trainer/updatetrainer/${trainer.trainerid}">Update</a></td>
                                <td><a href="${pageContext.request.contextPath}/trainer/deletetrainer/${trainer.trainerid}">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
        </c:choose>

        <div>
            <a href="${pageContext.request.contextPath}/user/adduser">Add new trainer</a>
        </div>
    </body>
</html>
