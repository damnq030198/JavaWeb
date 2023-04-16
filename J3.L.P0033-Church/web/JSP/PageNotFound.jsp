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
                            <h1>Page is maintaing now, please access later</h1>
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
