<%-- 
    Document   : Menu
    Created on : Sep 27, 2019, 10:57:53 AM
    Author     : sonnhhe130366
--%>

<%@page import="DAO.HtmlHelper"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/body.css" rel="stylesheet" type="text/css"/>
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
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
                            <div class="service-title">
                                <p class="menu-type-header">Service</p>
                            </div>
                            <div class="service-list">
                                <c:if test="${(error == false ? false : true)}">
                                    <table class="service-table">
                                        <c:forEach var="pl" items="${requestScope.pagingList}" >
                                            <tr>
                                                <td class="content service-date">${pl.displayDate}</td>
                                                <td class="page-title-h1">${pl.title}</td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td class="content">${pl.content}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                    <p>${requestScope.paging}</p>
                                </c:if>
                                <c:if test="${(error == true ? true : false)}">
                                    <p>This page does not have data</p>
                                </c:if>
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
