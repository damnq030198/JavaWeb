<%-- 
    Document   : Index
    Created on : Sep 16, 2019, 10:59:15 AM
    Author     : sonnhhe130366
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="header-container">
            <div class="header">
                <div class="header-content">
                    <div class="title-wrapper">
                        <div class="title-img">
                            <img src="${requestScope.book}" alt=""/>
                        </div>
                        <div class="title-wrapper-inner">
                            <div class="title">
                               Local Community Church 
                            <div class="sub-title">
                                Welcome to my website
                            </div>
                        </div>
                    </div>
                </div>
                <div class="header-direction">
                    <div class="direct-button-bar">
                        <a href="home" id="Home" onclick="action()" class="${requestScope.change == "home" ? "direct-button-click" : "direct-button"}">Home</a>
                        <a href="menu" class="${requestScope.change == "prayer" ? "direct-button-click" : "direct-button"}">Prayer</a>
                        <a href="service" class="${requestScope.change == "service" ? "direct-button-click" : "direct-button"}">Services</a>
                        <a href="findus" class="${requestScope.change == "findus" ? "direct-button-click" : "direct-button"}">Contact and Location</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
