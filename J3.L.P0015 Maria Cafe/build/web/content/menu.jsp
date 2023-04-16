<%-- 
    Document   : menu
    Created on : Oct 17, 2018, 1:36:04 PM
    Author     : vuhkse05427
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="menu">
    <a href="home" class="${param.menu == "home" ?"active" : ""}">Home</a>
    <a href="aboutmycake" class="${param.menu == 'aboutmycake'?"active" : ""}">About My Cake</a>
    <a href="aboutme" class="${param.menu == 'aboutme'?"active" : ""}">Find Maria's Cafe</a>
</div>