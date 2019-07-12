<%-- 
    Document   : addtrainer
    Created on : Jun 10, 2019, 12:23:08 AM
    Author     : Los_e
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
           prefix="springForm"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<title>JSP Page</title>-->
    </head>
    <body>
        <springForm:form method="Post" modelAttribute="trainer" action ="trainer/doaddtrainer">
            <table>
                <tr>
                    <td>Username</td> 
                    <td><springForm:input path="username"/></td> 
                    <td><springForm:errors path="username"/></td> 

                </tr>
                <tr>
                    <td>Password</td>
                    <td><springForm:input path="password"/></td> 
                    <td><springForm:errors path="password"/></td> 
                </tr>
                <td>First name</td>
                <td><springForm:input path="firstname"/></td> 
                <td><springForm:errors path="firstname"/></td> 
            </tr>
            <td>Last name</td>
            <td><springForm:input path="lastname"/></td> 
            <td><springForm:errors path="lastname"/></td> 
        </tr>
        <td>Subject</td>
        <td><springForm:input path="subject"/></td> 
        <td><springForm:errors path="subject"/></td> 
    </tr>
</table>
<input type="submit">
</springForm:form>
</body>
</html>
