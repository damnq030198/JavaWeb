<%-- 
    Document   : entrydetail
    Created on : Oct 17, 2018, 1:39:27 PM
    Author     : vuhkse05427
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entry</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <jsp:useBean id="e" class="bean.EntryBean"/>
        <jsp:setProperty name="e" property="id" value="${param.id}"/>
        <c:if test="${e.error}">
            <c:redirect url="error"/>
        </c:if>
        <c:if test="${not e.error}">
            <div class="container">
                <%@include file="content/header.jsp" %>
                <jsp:include page="content/menu.jsp?menu=aboutmycake"/>

                <div class="content">
                    <div class="main">
                        <%@include file="entry.jsp" %>
                    </div>
                    <%@include file="content/sidebar.jsp" %>
                </div>

                <%@include file="content/footer.jsp" %>
            </div>
        </c:if>
    </body>
</html>

