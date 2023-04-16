<%-- 
    Document   : overview
    Created on : Oct 17, 2018, 1:40:08 PM
    Author     : vuhkse05427
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>About my cake</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/overview.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="container">
            <%@include file="content/header.jsp" %>
            <jsp:include page="content/menu.jsp?menu=aboutmycake"/>
            <jsp:useBean id="products" class="bean.ProductBean"/>
            <c:if test="${param.page eq null}">
                <c:redirect url="aboutmycake?page=1"></c:redirect>
            </c:if>

            <jsp:setProperty name="products" property="page" value="${param.page}"/>
            <c:if test="${products.error}">
                <c:redirect url="error"/>
            </c:if>
            <c:if test="${not products.error}">

                <div class="content">
                    <div class="main">
                        <div class="item-overview">

                            <c:forEach items="${products.entries}" var="v">
                                <div class="cake">
                                    <div class="title"><a href="entrydetail.jsp?id=${v.id}">${v.name}</a></div>
                                    <img class="thumb" src="${v.imagePath}"/>
                                    <p>

                                        ${v.shortContent}
                                    </p>
                                </div>
                            </c:forEach>


                        </div>
                        <div class="paging">
                            <c:if test="${products.maxPage > 1}">
                                <c:if test="${param.page > 1}">
                                    <a href="?page=${param.page -1}">Prev</a>
                                </c:if>
                                [${products.page}]
                                <c:if test="${param.page < products.maxPage}">
                                    <a href="?page=${param.page + 1}">Next</a>
                                </c:if>
                            </c:if>
                        </div>

                    </div>

                    <%@include file="content/sidebar.jsp" %>
                </div>

            </c:if>

            <%@include file="content/footer.jsp" %>

        </div>

    </body>
</html>

