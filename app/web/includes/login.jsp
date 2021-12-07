<%-- any content can be specified here e.g.: --%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page pageEncoding="UTF-8" %>
<div class="container w-50 py-5 h-100 mx-auto"  id="modal" style="background-color: transparent;">
    <form id="login">
        <div class="card shadow-2-strong h-100" style="border-radius: 1rem;">
            <div class="card-body p-5 text-center">
                <div class="griddy">
                    <h3 class="mb-5">Sign in</h3>

                    <div class="form-outline mb-4">
                        <input type="email" id="email" autocomplete  name="email" class="form-control form-control-lg w-100" />
                        <label class="form-label" autocomplete for="email">Email</label>
                    </div>

                    <div class="form-outline mb-4">
                        <input type="password" id="password" name="password" class="form-control form-control-lg"/>
                        <label class="form-label" for="password">Password</label>
                    </div>
                    <button class="btn btn-primary my-5 btn-lg btn-block w-75" style="background: var(--green); color: var(--light);" type="submit">Login</button>
                    <button id="cancel" class="btn btn-secondary btn-lg btn-block w-75" style="background: var(--light); color: var(--marine);">Cancel</button>
                </div>
            </div>
        </div>
    </form>
</div>