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
                            <div class="img">
                                <div class="img-div">
                                    <img id="large" src="${requestScope.homeImg.imgLink}" alt=""/>
                                </div>
                            </div>
                            <div class="welcome">
                                <div class="welcome-title">
                                    <h1 class="menu-type-header">${requestScope.welcome.title}</h1>
                                </div>
                                <div class="welcome-content">
                                    <p class="content">${requestScope.welcome.shortContent}</p>
                                </div>
                            </div>
                            <div class="menu-list">
                                <div class="type-church-header">
                                    <p class="menu-type-header">${requestScope.about.title}</p>
                                </div>
                                <div class="type-church-content">
                                    <p class="content">
                                        <img id="type-img-detail" alt="" src="${requestScope.about.imgLink}">
                                        ${requestScope.about.fullContent}
                                    </p>
                                </div>
                            </div>
                            <div class="sign">
                                <div class="img-sign">
                                    <img id="sign-id" src="${requestScope.sign.imgLink}" alt=""/>
                                </div>
                                <div class="content low">
                                    <p class="cheer">${requestScope.sign.shortContent}</p>
                                    <p class="signal">${requestScope.sign.fullContent}</p>
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
