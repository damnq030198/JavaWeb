<%-- 
    Document   : home
    Created on : Oct 17, 2018, 1:33:51 PM
    Author     : vuhkse05427
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <%@include file="content/header.jsp" %>
            <jsp:include page="content/menu.jsp?menu=home"/>
            <jsp:useBean id="entry" class="bean.HomeBean"/>
            <c:if test="${entry.error}">
                <c:redirect url="error"/>
            </c:if>
            <c:if test="${!entry.error}">
                <div class="content">
                    <div class="main">
                        <div class="intro">
                            <div class="intro-image">
                                <img src="${entry.introduce.image}"/>
                            </div>
                            <div class="content-part">
                                ${entry.introduce.contentUp}
                            </div>
                        </div>
                        <div class="top-2">                            
                            <c:forEach items="${entry.lastestEntry}" var="e" varStatus="loop">

                                    <div class="lastest p${loop.index}">
                                        <img class="image" src="${e.imagePath}"/>
                                        <a href="detail?id=${e.id}"><h3>${e.name}</h3></a>
                                        <p>
                                            ${e.shortContent}
                                        </p>
                                    </div>
                                </c:forEach>
                            
                        </div>

                        <div class="intro">
                            <div class="content-full">
                                ${entry.introduce.contentDown}
                            </div>
                        </div>
                            <div class="intro">
                            <div class="content-full">
                                Kind Regard
                            </div>
                        </div>
                    </div>
                    <%@include file="content/sidebar.jsp" %>
                </div>
            </c:if>
            <%@include file="content/footer.jsp" %>

        </div>
    </body>
</html>

