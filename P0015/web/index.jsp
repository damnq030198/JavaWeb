<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home - Maria Bagnarelli's Cafe</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <div class="site-wrapper">
            <div class="header-wrapper">
                <div class="container">
                    <div class="title-wrapper">
                        <div class="title">Maria Bagnarelli's Cafe</div>
                        <div class="subtitle">Welcome to my website</div>
                    </div>
                    <div class="navbar">
                        <div class="container">
                            <ul class="nav">
                                <li><a href="LoadInfo" id="nav-active">Home</a></li>
                                <li><a href="LoadProduct">About my Cakes</a></li>
                                <li><a href="FindMyCafe.jsp">Find Maria's Cafe</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="content-wrapper">
                <div class="container">
                    <div class="content-left">
                        <div class="section intro">
                            <div class="content">
                                <div class="img">
                                    <img src="${shopInfo.introImage}">
                                </div>
                                <p class="content-title">Maria's Cosy Cafe</p>
                                ${shopInfo.introContent}
                            </div>
                        </div>
                        <div class="section">
                            <div class="content">
                                <ul>
                                    <c:forEach items="${topProducts}" var="product">
                                        <li class="product">
                                            <div class="img"><img src="${product.image}"</div>
                                            <div class="product-title"><a href="LoadProduct?ID=${product.ID}">${product.entryName}</a></div>
                                            <p>${product.entryContent}</p>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                        <div class="section intro">
                            <div class="content">
                                <p class="content-title">Visit my cafe</p>

                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</p>

                                <p>${shopInfo.address}</p>
                                <p>Phone: ${shopInfo.tel}</p>
                            </div>
                        </div>
                        <div class="section intro">
                            <div class="content">
                                Kind regards<br/>
                                <div class="signature">${shopInfo.signature}</div>
                            </div>
                        </div>
                    </div>
                    <div class="content-right">
                        <div class="share-box">
                            <div class="share-header">Share this page</div>
                            <div class="share-content">
                                <div><a href="">Share on Facebook</a></div>
                                <div><a href="">Share on Twitter</a></div>
                                <div><a href="">Share on Google+</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="footer-wrapper">
                <div class="container">
                    <div class="footer-info"><a href="">Created with SimpleSite</a></div>
                    <div class="footer-counter">
                        <span class="counter-item">0</span>
                        <span class="counter-item">2</span>
                        <span class="counter-item">8</span>
                        <span class="counter-item">6</span>
                        <span class="counter-item">6</span>
                        <span class="counter-item">7</span>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
