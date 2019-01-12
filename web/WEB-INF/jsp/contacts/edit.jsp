<%-- 
    Document   : edit
    Created on : 12-jan-2019, 11:34:20
    Author     : ief
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EDIT</title>
        
        <spring:url value="/css/style.css" var="urlCss"/>
        <link rel="stylesheet" href="${urlCss}" type="text/css" />
        
        <spring:message code="label_contact_new" var="labelContactNew"/>
        <spring:message code="label_contact_update" var="labelContactUpdate"/>
        <spring:message code="label_contact_first_name" var="labelContactFirstName"/>
        <spring:message code="label_contact_last_name" var="labelContactLastName"/>
        <spring:message code="label_contact_birth_date" var="labelContactBirthDate"/>
        <spring:message code="label_contact_description" var="labelContactDescription"/>
        <spring:message code="label_contact_photo" var="labelContactPhoto"/>

        <spring:url value="/contacts/edit/" var="editContactUrl"/> 
        
         <script src="${jquery_ui_url}" type="text/javascript"><jsp:text/></script>

        <script type="text/javascript">
            $(function () {
                $('#birthDate').datepicker({
                    dateFormat: 'yy-mm-dd',
                    changeYear: true
                });

                $("#contactDescription").ckeditor(
                        {
                            toolbar: 'Basic',
                            uiColor: '#CCCCCC'
                        }
                );
            });
        </script>

    </head>
    <body>
        <spring:message code="label_contact_new" var="labelContactNew"/>
        <spring:message code="label_contact_update" var="labelContactUpdate"/>
        <spring:eval expression="contact.id == null?
                     labelContactNew:labelContactUpdate" var="formTitle"/>
        <h1>${formTitle}</h1>
        <form:form modelAttribute="contact" method="post">
            <c:if test="${not empty message}">
                <h3 id="error" class="${message.type}">
<!--                    <div id="error" class="${message.type}">-->
                        ${message.message}
<!--                    </div>-->
                </h3>
            </c:if>
            <form:hidden path="id" />

            <p><label>${labelContactFirstName}*</label>
                <form:input path="firstName" size = "20"/>
                <form:errors path="firstName" cssClass="error"/>
            </p>


            <p><label>${labelContactLastName}*</label>
                <form:input path="lastName" size = "20"/>
                <form:errors path="lastName" cssClass="error"/>
            </p>


            <p><label>${labelContactBirthDate}*</label>
                <form:input path="birthday" size = "20" id="birthDate"/>
                <form:errors path="birthday" cssClass="error"/>
            </p>


            <p><label>${labelContactDescription}*</label>
                <form:textarea cols="60" rows="8" path="description" id="contactDescription"/>
                <form:errors path="description" cssClass="error"/>
            </p>


            <form:hidden path="version" />

            <input type="submit" align="center" value="Save"/>&nbsp;
            <input type="reset" align="center" value="Reset"/>
        </form:form>
    </body>
</html>
