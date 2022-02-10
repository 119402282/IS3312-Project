<%@page import="Model.OrderItems"%>
<%@page import="Model.Trolley"%>
<%@page import="Util.BootUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Boot"%>
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
        <div class="container w-75">
            
            <div class="row">
                <h1 class="page-title">Trolley</h1>
            </div>
            <% 
                User currentUser = (User)session.getAttribute("SESSION_USER");
                Trolley cart = currentUser.getTrolley();
                ArrayList<OrderItems> bootsInCart = cart.getBundleOfBoots();
                if(bootsInCart.size() == 0){
            %>
            <div class="container" style="display: grid; place-items: center; width: 100%; height: 50vh; justify-content: center;">
                <div>
                    <h2>Your trolley is empty, want to look for some <a href="boots.jsp" style="color: var(--green);">Boots</a>!</h2>
                </div>
            </div>
            <%
                } else {
                    for(OrderItems lineItem : cart.getBundleOfBoots()){
            %>
            <div class="row mb-4 line-item">
                <div class="col-md-5 col-lg-3 col-xl-3">
                    <img class="product-img img-fluid w-100" src="assets/product-images/<%= lineItem.getBoot().getCode()%>.jpg" alt="Image of boot">    
                </div>
                <div class="col-md-7 col-lg-9 col-xl-9">
                    <div>
                        <div class="d-flex justify-content-between">
                            <div>
                                <h4 class="pb-1"><%= lineItem.getBoot().getName()%></h4>
                                <h6><%= lineItem.getBoot().getBrand()%></h6>
                                <p>Size: <%= lineItem.getBoot().getSize()%></p>
                                <p class="pb-1">Price per unit: <%= lineItem.getBoot().getPrice()%></p>
                            </div>
                            <div>
                                <label for="quantity">Quantity: <%= lineItem.getQuantity()%></label>
                                <select class="form-control" id="quantity">
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                    <option value="10">10</option>
                                </select>
                            </div>  
                        </div>
                        <div class="d-flex justify-content-between align-items-center">
                            <div>
                                <a href="" type="button" style="color: var(--green);" class="small text-uppercase mr-3">Remove item </a>
                            </div>
                            <p class="mb-0"><span><strong id="summary">€<%= lineItem.getCost()%></strong></span></p class="mb-0">
                        </div>
                    </div>
                </div>
            </div>

            <% 
                    }
            %>
        </div>
        <div id="checkout" class="w-75 mx-auto">
            <a href="index.jsp" class="btn btn-primary d-block w-50 mx-auto" style="background-color: var(--green);">Checkout</a>
        </div>
        <%
            }
        %>
        <!-- Footer-->
        <footer id="footer">
            <p class="mx-auto text-center">info@hikersdelight.com</p>
            <p class="mx-auto text-center">HikersDelight 2021</p>
        </footer>
    </body>
</html>
