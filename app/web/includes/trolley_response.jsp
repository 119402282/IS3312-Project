<%-- 
    Document   : trolley_response
    Created on : 11 Feb 2022, 15:13:15
    Author     : culle
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if(request.getAttribute("message") != null){
        String[] message = (String[])request.getAttribute("message");
%>
<div id="AlertMe" class="alert alert-danger position-fixed alert-dismissible fade" style="top: 10%;right: 5%; z-index: 10;" role="alert">
    <div id="trolleyMessage" class="d-inline-block" style="max-width: 50ch"> 
    </div>
</div>
<script defer>
    
    let toastMess = document.getElementById('trolleyMessage');
    let alertMe = document.getElementById('AlertMe');
    let outputMe = '<%=message[1]%>'; 
    toastMess.innerHTML = outputMe;
        alertMe.classList.toggle('show');
        setTimeout(function() {
            alertMe.classList.toggle('show');
        }, 2500);
</script>

<%
    }
%>
