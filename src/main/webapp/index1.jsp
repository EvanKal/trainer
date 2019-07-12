<%-- 
    Document   : index
    Created on : Jun 9, 2019, 10:05:30 PM
    Author     : Los_e
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello</title>
    </head>
    <body>
         <body>
        <c:choose>

            <c:when test = "${books.size() == 0}">
                <p>No results. Currently no books</p>
            </c:when>

            <c:when test = "${books.size() > 0}">
                <table style="border-collapse: collapse;">
                    <thead>
                        <tr>
                            <td style="border: 1px solid black;">ISBN</td>
                            <td style="border: 1px solid black;">Title</td>
                            <td style="border: 1px solid black;">Author</td>
                            <td style="border: 1px solid black;">Category</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${books}" var="book">
                            <tr>
                                <td style="border: 1px solid black;">${book.isbn}</td>
                                <td style="border: 1px solid black;">${book.title}</td>
                                <td style="border: 1px solid black;">${book.author}</td>
                                <td style="border: 1px solid black;">${book.category}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
        </c:choose>

    </body>
    </body>
</html>