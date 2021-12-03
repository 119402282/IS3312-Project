<%-- 
    Document   : newjsp
    Created on : 3 Dec 2021, 03:41:25
    Author     : Henry Cullen <119402282%40umail.ucc.ie>
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach items="${bootsList}" var="boot">
            
            <div class="card">
                <img class="card-img-top" src="assets/product-images/${boot.code}.jpg" alt="Card image cap">
                <div class="card-body">
                    <h4 class="card-title"><fmt:formatNumber value="${boot.price}" currencySymbol="€" type="currency"/> - ${boot.name}</h4>
                    <h6>${fn:toUpperCase(boot.brand)}</h6>
                    <p>Size: ${boot.size}</p>
                    <p>Type: ${boot.type}</p>
                    <p class="card-text">Color: ${boot.color}</p>
                    <span><a href="product.html" class="btn btn-primary">View Product</a></span>
                </div>
            </div>
        </c:forEach>
    </body>
</html>
