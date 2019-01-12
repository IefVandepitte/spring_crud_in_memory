<%-- 
    Document   : list
    Created on : 12-jan-2019, 11:34:06
    Author     : ief
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LIST</title>
    </head>
    <body>
        <spring:url value="/contacts/" var="showContactUrl"/>
        <table>
            <c:forEach items="${contactList}" var="contact" varStatus="status">           
                <tr>
                    <td>
                        <a href="${showContactUrl}${contact.id}">
                           ${contact.firstName}
                        </a>
                    </td>   
                </tr>                      
            </c:forEach>
        </table> 
    </body>
</html>
