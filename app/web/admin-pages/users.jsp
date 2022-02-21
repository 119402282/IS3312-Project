<%@page import="java.util.ArrayList"%>
<%@page import="DAO.UserDAO"%>
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
        <title>Manage Users - HikersDelight</title>
        <link href="css/style.css" rel="stylesheet" />
        <script src="js/index.js" defer type="text/javascript"></script>
        <script src="js/modal.js" defer type="text/javascript"></script>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <!-- Navigation-->
        <%@ include file="/includes/navbar.jsp" %>
        <!-- Modal -->
        
        <%@ include file="/includes/login.jsp" %>
        
        <div class="space"></div>
        
            
        <div class="container">
            <div class="row">
                <div style="display: flex; justify-content: space-between">
                        <h1 class="page-title">User</h1>
                        <a href="./admin.jsp" class="page-title"><h2>Admin Home</h2></a>
                </div>
            </div>
            <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">Email</th>
                        <th scope="col">Full Name</th>
                        <th scope="col">Type</th>
                        <th scope="col">Eircode</th>
                        <th scope="col">Password</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${allUsers}" var="usr">
                        <c:url value="/admin" var="saveProd">
                            <c:param name="action" value="save"/>
                            <c:param name="class" value="user"/>
                            <c:param name="id" value="${usr.email}"/>
                        </c:url>
                        <c:url value="/admin" var="delProd">
                            <c:param name="action" value="delete"/>
                            <c:param name="class" value="user"/>
                            <c:param name="id" value="${usr.email}"/>
                        </c:url>
                    <tr>
                        <form method="post" action="">
                            <td scope="row">${usr.email}</td>
                            <td><input  class="form-control" type="text" name="name" value="${usr.fullName}" required></input></td>
                            <td>
                                <input class="form-check-input" type="radio" id="user${usr.email}" name="type" value="USER" <c:if test = "${usr.type == 'USER'}"><c:out value = "checked"/></c:if> required>
                                <label class="form-check-label" for="user${usr.email}">USER</label>
                                <input class="form-check-input" type="radio" id="adm${usr.email}" name="type" value="ADMIN" <c:if test = "${usr.type == 'ADMIN'}"><c:out value = "checked"/></c:if> >
                                <label class="form-check-label" for="adm${usr.email}">ADMIN</label>
                            </td>
                            <td><input  class="form-control" type="text" name="eircode" value="${usr.eircode}" required></input></td>
                            <td><input  class="form-control" type="password" name="password" value="${usr.password}" required></input></td>
                            <td><button class="btn btn-primary" type="submit" formaction="${saveProd}">Save</button></td>
                            <td><button class="btn btn-warning" type="submit" formaction="${delProd}"> Delete</button></td>
                        </form>
                    </tr>
                    </c:forEach>
                    <tr>
                        <form method="post" action="">
                            <td scope="row"><input  class="form-control" type="email" name="id"  required></input></td>
                            <td><input  class="form-control" type="text" name="name"  required></input></td>
                            <td>
                                <input class="form-check-input" type="radio" id="userNew" name="type" value="USER" >
                                <label class="form-check-label" for="userNew">USER</label>
                                <input class="form-check-input" type="radio" id="admNew" name="type" value="ADMIN" required>
                                <label class="form-check-label" for="admNew">ADMIN</label>
                            </td>
                            <td><input  class="form-control" type="text" name="eircode" value="" required></input></td>
                            <td><input  class="form-control" type="password" name="password" value="" required></input></td>
                            <c:url value="/admin" var="addProd">
                                <c:param name="action" value="add"/>
                                <c:param name="class" value="user"/>
                            </c:url>
                            <td colspan="2"><button class="btn btn-primary" type="submit" formaction="${addProd}"> Add</button></td>
                        </form>
                    </tr>
                </tbody>
            </table>
            </div>
        </div>
        <script>
            let pop = document.querySelector('div#alert-troller').remove();
            let pop2 = document.querySelector('.alert.alert-warning.position-fixed.alert-dismissible.fade').remove();
        </script>
    </body>
</html>
