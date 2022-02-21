<%-- any content can be specified here e.g.: --%>
<%@page import="java.util.Objects"%>
<%@page import="Model.User"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page pageEncoding="UTF-8" %>

<% 
    String uri = request.getRequestURI();
    String pageName = uri.substring(uri.lastIndexOf("/")+1);
    boolean notHome = pageName.endsWith(".jsp");
    if(!notHome){
        pageName = "index.jsp";
    }
%>

<nav id="nav" class="container-fluid px-3 px-lg-5 w-100">
    <a class="navbar-brand" href="index.jsp">HikersDelight</a>
    <ul>
        <li><a class="" href="./boots.jsp">Boots</a></li>
        <%
            HttpSession sesh = request.getSession(true);
            User currUser = (User) sesh.getAttribute("SESSION_USER");
            if(Objects.isNull(currUser)){
        %>
            <li><a class="" href="#" id="btn-login">Login</a></li>
            <li><a class="" href="#" onclick="alertTroller()">Trolley</a></li>
        <%
            } else if (currUser.getType().equals("ADMIN") || currUser.getType().equals("USER")){
        %>
            <li><a class="" href="./end" >Logout</a></li>
            <li><a class="" href="trolley.jsp">Trolley</a></li>
        <%
            } else {
        %>
             <li><a class="" href="#" id="btn-login">Login</a></li>
             <li><a class="" href="#" onclick="alertTroller()">Trolley</a></li>
        <%
            }
        %>
             
    </ul>
</nav>
<div id="alert-troller" class="alert alert-warning position-fixed alert-dismissible fade" style="top: 12%;right: 5%; z-index: 10;" role="alert">
    <div id="toast-troller" class="d-inline-block" style="max-width: 50ch">
        You must login as a user to access your trolley.
    </div>
</div>
    <script defer>
        const current = document.querySelector('nav a[href="<%=pageName%>"]');
        current.classList.add('current');
        current.setAttribute('href','#');
        
        function alertTroller(){
            let trollerAl = document.getElementById('alert-troller');
            trollerAl.classList.toggle('show');
            setTimeout(function() {
            trollerAl.classList.toggle('show');
        }, 2500);
        }
    </script>
    
