<%@ include file="common/header.jspf" %>
<%@ include file="common/navigator.jspf" %>
<div class="container">
    <h1>Welcome To First Web Site With Spring Boot 5.0</h1>
    <div>
        <div>
            Name : ${name}
        </div>
        <a href="getTodos">Manage</a> Todos
    </div>
</div>
<%@ include file="common/footer.jspf" %>