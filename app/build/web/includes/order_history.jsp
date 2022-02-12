<%-- 
    Document   : trolley_response
    Created on : 11 Feb 2022, 15:13:15
    Author     : culle
--%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="Model.OrderItems"%>
<%@page import="Model.Trolley"%>
<%@page import="Model.User"%>
<%@page import="java.sql.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if(request.getAttribute("date") != null){
        Date today = (Date)request.getAttribute("date");
        Locale irish = new Locale("en", "IE");
        User currentUser = (User)session.getAttribute("SESSION_USER");
        Trolley lastOrder = currentUser.getOrderHistory().get(currentUser.getOrderHistory().size()-1);
%>
<div id="alertCheck" class="alert alert-success position-fixed alert-dismissible fade" style="top: 10%;right: 5%; z-index: 10;padding-right: 16px !important;" role="alert">
    <div id="checkoutMessage" class="d-inline-block"> 
        <p>Your order at <%= today.getTime()%> <%= today%>.</p>
        <table style="width:100%;">
            <thead>
                <tr><th>Product</th><th>Quantity</th><th>Cost</th></tr>
            </thead>
            <tbody>
                <%
                    for(OrderItems item : lastOrder.getBundleOfBoots()){
                %>
                <tr><td><%=item.getBoot().getName().substring(0,18)%>...</td><td> x <%=item.getQuantity()%></td><td><%=NumberFormat.getCurrencyInstance(irish).format(item.getCost())%></td></tr>
                <%
                    }
                %>
            </tbody>
            <tfoot>
                <tr>
                    <th colspan="2">Total Price</th><th><%=NumberFormat.getCurrencyInstance(irish).format(lastOrder.getTotalPrice())%></th>
                </tr>
            </tfoot>
        </table>
    </div>
</div>
<script defer>
    
    let checkMess = document.getElementById('checkoutMessage');
    let alertCheck = document.getElementById('alertCheck');
        alertCheck.classList.toggle('show');
        setTimeout(function() {
            alertCheck.classList.toggle('show');
        }, 6000);
</script>

<%
    }
%>
