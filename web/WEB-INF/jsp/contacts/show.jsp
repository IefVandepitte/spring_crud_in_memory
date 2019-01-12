<%-- 
    Document   : show
    Created on : 12-jan-2019, 11:14:44
    Author     : ief
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags/" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SHOW</title>
    </head>

    <body>
        <spring:url value="/contacts/edit/" var="editContactUrl"/>
        <spring:message code="date.format.pattern" var="dateFormatPattern"/>
        <table>
            <tr>
                <td>
                    Name
                </td>
                <td>
                    ${contact.firstName}
                </td>
            </tr>
            <tr>
                <td>
                    Lastname
                </td>
                <td>
                    ${contact.lastName}
                </td>
            </tr>
            <tr>
                <td>
                    description
                </td>
                <td>
                    ${contact.description}
                </td>
            </tr>
            <tr>
                <td>
                    birthday
                </td>
                <td>
                    <tags:localDate date="${contact.birthday}" 
                                    pattern="${dateFormatPattern}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <a href="${editContactUrl}${contact.id}">Update</a>
                </td>
                <td></td>
            </tr>
            
        </table>
    </body>
</html>
