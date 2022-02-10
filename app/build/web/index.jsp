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
        <title>Home - HikersDelight</title>
        <link href="css/style.css" rel="stylesheet" />
        <script src="js/index.js" defer type="text/javascript"></script>
        <script src="js/modal.js" defer type="text/javascript"></script>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <!-- CSS only -->

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </head>
    <body>
        <!-- Navigation-->
       <%@ include file="/includes/navbar.jsp" %>
        
        <!-- Modal -->
        
        <%@ include file="/includes/login.jsp" %>

        <!-- Header-->
        <div class="space"></div>
        <header>
            <div class="container px-4 px-lg-5">
                <div class="text-center">
                    <h1 class="py-5 display-4 fw-bolder">Boots that will take you to new heights</h1>
                    <a href="boots.jsp"><button class="btn btn-primary">View the Boots</button></a>    
                </div>
            </div>
        </header>
        <!-- Section-->
        <section id="snow">
            <div class="boot">
                <div class="boot-image">
                    <img src="assets/snow-2.jpg" alt="" />
                </div>
                <div class="boot-text">
                    <h2>Snow Boots</h2>
                    <p>Looking for the perfect arctic boot. A boot that can keep you warm no matter the altitude. Snow boots are our newest and most popular product. If you are going on any snowy mountains these boots are a necessity</p>
                </div>
            </div>  
        </section>
        <section id="forest">
            <div class="boot boot-reverse">
                <div class="boot-image">
                    <img src="assets/forest-1.jpg" alt="" />
                </div>
                <div class="boot-text">
                    <h2>Hiking Boots</h2>
                    <p>These boots are for those who seet out adventure. They are breathable and grippy; the perfect product for an intense climb. They are designed to get the most traction even in wet and windy conditions.</p>
                </div>
            </div>  
        </section>
        <section id="farm">
            <div class="boot">
                <div class="boot-image">
                    <img src="assets/garden-1.jpg" alt="">
                </div>
                <div class="boot-text">
                    <h2>Garden Boots</h2>
                    <p>Are you a horticulturist or a green fingered nature lover. Wellington boots are a domestic all purpose boot for when you have a job that is going to be dirty. They are a comfort fit and also higly water proof as long as you don't go poking any holes in them.</p>
                </div>
            </div>  
        </section> 
        <section id="water">
            <div class="boot boot-reverse">
                <div class="boot-image">
                    <img src="assets/water-1.jpg" alt="">
                </div>
                <div class="boot-text">
                    <h2>Sailing Boots</h2>
                    <p>Looking for the perfect arctic boot. A boot that can keep you warm no matter the altitude. Snow boots are our newest and most popular product. If you are going on any snowy mountains these boots are a necessity</p>
                </div>
            </div>  
        </section>
        <section id="street">
            <div class="boot">
                <div class="boot-image">
                    <img src="assets/street-1.jpg" alt="">
                </div>
                <div class="boot-text">
                    <h2>Street Boots</h2>
                    <p>Looking for the perfect arctic boot. A boot that can keep you warm no matter the altitude. Snow boots are our newest and most popular product. If you are going on any snowy mountains these boots are a necessity</p>
                </div>
            </div>  
        </section>
        <!-- Footer-->
        <footer id="footer">
            <p class="mx-auto text-center">info@hikersdelight.com</p>
            <p class="mx-auto text-center">HikersDelight 2021</p>
        </footer>
    </body>
</html>
