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
        <title>Trolley - HikersDelight</title>
        <link href="css/style.css" rel="stylesheet" />
        <script src="js/index.js" defer type="text/javascript"></script>
        
        <script src="js/modal.js" defer type="text/javascript"></script>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
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
        <div class="container w-75">
            <div class="row">
                <h1 class="page-title">Trolley</h1>
            </div>
            <div class="row mb-4 line-item">
                <div class="col-md-5 col-lg-3 col-xl-3">
                    <img class="product-img img-fluid w-100" src="assets/product-images/1.jpg" alt="Image of boot">    
                </div>
                <div class="col-md-7 col-lg-9 col-xl-9">
                    <div>
                        <div class="d-flex justify-content-between">
                            <div>
                                <h4 class="pb-1">Off-Piste Extreme Mens Snowboots</h4>
                                <h6>MOUNTAIN WAREHOUSE</h6>
                                <p>Size: 42</p>
                                <p class="pb-1">Price per unit: â¬59.99</p>
                            </div>
                            <div>
                                <label for="quantity">Quantity:</label>
                                <select class="form-control" id="quantity">
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                </select>
                            </div>  
                        </div>
                        <div class="d-flex justify-content-between align-items-center">
                            <div>
                                <a href="" type="button" style="color: var(--green);" class="small text-uppercase mr-3">Remove item </a>
                            </div>
                            <p class="mb-0"><span><strong id="summary">â¬59.99</strong></span></p class="mb-0">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div id="checkout" class="w-75 mx-auto">
            <a href="index.jsp" class="btn btn-primary d-block w-50 mx-auto" style="background-color: var(--green);">Checkout</a>
        </div>
        <!-- Footer-->
        <footer id="footer">
            <p class="mx-auto text-center">info@hikersdelight.com</p>
            <p class="mx-auto text-center">HikersDelight 2021</p>
        </footer>
    </body>
</html>
