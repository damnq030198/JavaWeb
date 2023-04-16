<%-- 
    Document   : Right
    Created on : Sep 25, 2019, 12:22:41 PM
    Author     : sonnhHE130366
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/body.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="share">
            <div class="box">
                <h4 class="header-share">Share this page</h4>
                <c:forEach items="${requestScope.shareList}" var="s">
                    <img src="${s.icon}" alt=""/>
                    <a class="shareLink content" href="${s.url}">Share on ${s.socialNetwork}</a><br/>
                </c:forEach>
            </div>
            <div class="box box-below">
                <h4 class="header-share">Create a website</h4>
                <div>
                    <p class="try-box content">Everybody can create a website, it's easy.</p>
                </div>
                <div>
                    <button class="try-button">Try it for FREE now</button>
                </div>
            </div>
        </div>
    </body>
</html>
