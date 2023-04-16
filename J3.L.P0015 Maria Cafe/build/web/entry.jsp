<%-- 
    Document   : entry
    Created on : Oct 17, 2018, 1:38:33 PM
    Author     : vuhkse05427
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="entry">
    <div class="item">
        <a href="detail?id=${e.id}">${e.title}</a>
        <div class="content-item">
            <img class="right" src="${e.imagePath}"/>
            <p>
                ${e.itemContent}
            </p>
        </div>
    </div>
</div>
