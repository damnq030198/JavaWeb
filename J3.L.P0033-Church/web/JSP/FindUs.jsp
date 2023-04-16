<%-- 
    Document   : Body
    Created on : Sep 18, 2019, 11:05:25 AM
    Author     : sonnhhe130366
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Shared"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/body.css" rel="stylesheet" type="text/css"/>
        <link href="css/findus.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="wrapper">
            <div class="inner-wrapper">
                <div class="">
                    <jsp:include page="Header.jsp" />
                </div>
                <div class="body-container">
                    <div class="body-content">
                        <div class="body-left">
                            <div>
                                <p class="menu-type-header">Contact and Location</p>
                            </div>
                            <div class="findus-content">
                                <div class="findus-content-col">
                                    <div class="addNContact-title">
                                        <p class="page-title-h1">Local Community Church</p>
                                        <table>
                                            <c:forEach var="add" items="${requestScope.inforADList}">
                                                <tr><td class="content">${add.content}</td></tr>
                                            </c:forEach>                                       
                                        </table>
                                        <table class="contact-table">
                                             <c:forEach var="contact" items="${requestScope.contactInforList}">
                                                <tr>
                                                    <td class="content">${contact.contact}</td>
                                                    <td class="content">${contact.detail}</td>
                                                </tr>
                                            </c:forEach>        
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="body-right">
                            <jsp:include page="Right.jsp" />
                        </div>
                    </div>
                </div>
                <div>
                    <jsp:include page="Footer.jsp"/>
                </div>
            </div>
        </div>
    </body>
</html>
