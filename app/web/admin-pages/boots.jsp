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
        <title>Manage Boots - HikersDelight</title>
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
                    <h1 class="page-title">Boots</h1>
                    <a href="./admin.jsp" class="page-title" ><h2>Admin Home</h2></a>
                </div>
            </div>
            <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">Code</th>
                        <th scope="col">Name</th>
                        <th colspan="3" scope="col">Description</th>
                        <th scope="col">Type</th>
                        <th scope="col">Size</th>
                        <th scope="col">Color</th>
                        <th scope="col">Price</th>
                        <th scope="col">Brand</th>
                        <th scope="col">Image</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${bootsList}" var="bt">
                        <c:url value="/admin" var="saveProd">
                            <c:param name="action" value="save"/>
                            <c:param name="class" value="boot"/>
                            <c:param name="id" value="${bt.code}"/>
                        </c:url>
                        <c:url value="/admin" var="delProd">
                            <c:param name="action" value="delete"/>
                            <c:param name="class" value="boot"/>
                            <c:param name="id" value="${bt.code}"/>
                        </c:url>
                    <tr>
                        <form method="post" action="">
                            <td scope="row">${bt.code}</td>
                            <td><input  class="form-control" type="text" name="name" value="${bt.name}" required></input></td>
                            <td colspan="3"><textarea class="form-control" name="description" rows="10" required>${bt.description}</textarea></td>
                            <td>
                                <select class="form-select"  name="boottype" required>
                                    <option value="fashion" <c:if test = "${bt.type == 'Street'}"><c:out value = "selected"/></c:if>>Street</option>
                                    <option value="wellington" <c:if test = "${bt.type == 'Wellington'}"><c:out value = "selected"/></c:if>>Wellington</option>
                                    <option value="snow" <c:if test = "${bt.type == 'Snow'}"><c:out value = "selected"/></c:if>>Snow</option>
                                    <option value="forest" <c:if test = "${bt.type == 'Hiking'}"><c:out value = "selected"/></c:if>>Hiking</option>
                                    <option value="water" <c:if test = "${bt.type == 'Sailing'}"><c:out value = "selected"/></c:if>>Sailing</option>
                                </select>
                            </td>
                            <td style="width: 70px !important;"><input class="form-control" style="width: 70px !important;" type="number" max="65" min="25" name="size" value="${bt.size}" required></input></td>
                            <td><input class="form-control" type="text" name="color" value="${bt.color}" required></input></td>
                            <td style="width: 90px !important;"><input class="form-control" style="width: 90px !important;" type="number" name="price" min="5" step="0.01" value="${bt.price}" style="width: 70px !important;" required></input></td>
                            <td><input  class="form-control" type="text" name="brand" value="${bt.brand}" required></input></td>
                            <td>Upload image</td>
                            <td><button class="btn btn-primary" type="submit" formaction="${saveProd}">Save</button></td>
                            <td><button class="btn btn-warning" type="submit" formaction="${delProd}"> Delete</button></td>
                        </form>
                    </tr>
                    </c:forEach>
                    <tr>
                        <form method="post" action="">
                            <td scope="row">${bt.code}</td>
                                <td><input  class="form-control" type="text" name="name" value="${bt.name}"></input></td>
                                <td colspan="3"><textarea class="form-control" name="description" rows="10" required></textarea></td>
                                <td>
                                    <select class="form-select"  name="boottype" required>
                                        <option value="fashion" >Street</option>
                                        <option value="wellington" >Wellington</option>
                                        <option value="snow" >Snow</option>
                                        <option value="forest" >Hiking</option>
                                        <option value="water" >Sailing</option>
                                    </select>
                                </td>
                                <td style="width: 70px !important;"><input class="form-control" style="width: 70px !important;" type="number" max="65" min="25" name="size"  required></input></td>
                                <td><input class="form-control" type="text" name="color" required></input></td>
                                <td style="width: 90px !important;"><input class="form-control" style="width: 90px !important;" type="number" name="price" min="5" step="0.01" required></input></td>
                                <td><input  class="form-control" type="text" name="brand"  required></input></td>
                                <td>Upload image</td>
                            <c:url value="/admin" var="addProd">
                                <c:param name="action" value="add"/>
                                <c:param name="class" value="boot"/>
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
