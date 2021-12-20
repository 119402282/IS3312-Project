<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="Site for selling Boots" />
        <meta name="author" content="Henry Cullen" />
        <title>${boot.name} - HikersDelight</title>
        <link href="css/style.css" rel="stylesheet" />
        <script src="js/index.js" defer type="text/javascript"></script>
        
        <script src="js/modal.js" defer type="text/javascript"></script>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <!-- Navigation-->
        <%@ include file="/includes/navbar.jsp" %>
        <!-- Modal -->
        
        <%@ include file="/includes/login.jsp" %>
        <!-- Header-->
        <div class="space"></div>
        <div class="container">
            <div class="row">
                <h1 class="page-title">${boot.name} - <fmt:formatNumber value="${boot.price}" currencySymbol="€" type="currency"/></h1>
            </div>
            <div id="product-container" class="row">
                <div class="image-container">
                    <img class="product-img" src="assets/product-images/${boot.code}.jpg" alt="product image">
                </div>
                <div class="product-details">
                    <div class="product-body">
                        <h4 class="pb-1">${boot.name}</h4>
                        <p>Size: ${boot.size}</p>
                        <p>Type: ${boot.type}</p>
                        <p>Color: ${boot.color}</p>
                        <h6>${fn:toUpperCase(boot.brand)}</h6>
                        <p class="pb-1">Description: ${boot.description}</p>
                        <span><a href="trolley.jsp?add=${boot.code}" class="btn btn-primary">Buy Product for <fmt:formatNumber value="${boot.price}" currencySymbol="€" type="currency"/></a></span>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- Footer-->
        <footer id="footer">
            <p class="mx-auto text-center">info@hikersdelight.com</p>
            <p class="mx-auto text-center">HikersDelight 2021</p>
        </footer>
    </body>
</html>
