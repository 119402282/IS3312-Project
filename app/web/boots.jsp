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
        <title>Boots - HikersDelight</title>
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
        <script>
            $(function () {
                $('[data-toggle="tooltip"]').tooltip()
            })
        </script>

    </head>
    <body>
        <!-- Navigation-->
        <%@ include file="/includes/navbar.jsp" %>
        <!-- Modal -->
        
       <%@ include file="/includes/login.jsp" %>
       <%@ include file="/includes/trolley_response.jsp" %>
        <!-- Header-->
        <div class="space"></div>
        <div class="container">
            <div class="row">
                <h1 class="page-title">Boots</h1>
            </div>
            <div class="products pb-3 mb-5">
                <c:forEach items="${bootsList}" var="boot">
                <div class="card">
                    <img class="card-img-top" src="assets/product-images/${boot.code}.jpg" alt="Card image cap">
                    <div class="card-body">
                        <a href="./product?code=${boot.code}"><h4 class="card-title" data-toggle="tooltip" data-placement="bottom" title="<fmt:formatNumber value="${boot.price}" currencySymbol="€" type="currency"/> - ${boot.name}"><fmt:formatNumber value="${boot.price}" currencySymbol="€" type="currency"/> - ${boot.name}</h4></a>
                        <h6>${fn:toUpperCase(boot.brand)}</h6>
                        <p>Size: ${boot.size}</p>
                        <p>Type: ${boot.type}</p>
                        <p class="card-text">Color: ${boot.color}</p>
                        <span><a href="./trolley?add=${boot.code}" class="btn btn-primary">Buy Product</a></span>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>
        <!-- Footer-->
        <footer id="footer">
            <p class="mx-auto text-center">info@hikersdelight.com</p>
            <p class="mx-auto text-center">HikersDelight 2021</p>
        </footer>
    </body>
</html>
