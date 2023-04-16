<%-- 
    Document   : aboutme
    Created on : Oct 17, 2018, 1:32:34 PM
    Author     : vuhkse05427
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Find Maria's Cafe</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/aboutme.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <%@include file="content/header.jsp" %>
            <jsp:include page="content/menu.jsp?menu=aboutme"/>
            <jsp:useBean id="info" class="bean.InformationBean"/>
            <c:if test="${info.error}">
                <c:redirect url="error"/>
            </c:if>
            <c:if test="${not info.error}">
                <div class="content">
                    <div class="main">
                        <div class="title">${info.title}</div>
                        <div class="contact">
                            <h3>Address and contact:</h3>
                            <c:forEach items="${info.contact}" var="v">
                                <br>
                                ${v.contact}<br><br>
                                Tel : ${v.phone}<br>
                                Mail : ${v.mail}<br>
                            </c:forEach>
                        </div>

                        <div class="contact">
                            <h3>Opening Hour:</h3>
                            <br>
                            <c:forEach items="${info.openingHour}" var="v">
                                ${v.days} : ${v.hour}<br>
                            </c:forEach>
                            
                        </div>
                        <div class="map">
                            <img src="${info.map}" />
                        </div>
                    </div>
                    <%@include file="content/sidebar.jsp" %>
                </div>
                <%@include file="content/footer.jsp" %>
            </c:if>
        </div>

    </body>
</html>

