<%@ include file="common/header.jspf" %>
<%@ include file="common/navigator.jspf" %>
<div class="container">
    <h1>Welcome Back ${name}</h1>
    <!-- <form method="POST">
        Search : <input type="text" name="userName" placeholder="userName">
        <input type="submit">
    </form> -->
    <div>
        <hr>
        <table class="table">
            <thead>
                <tr>
                    <th>Description</th>
                    <th>Time To Complete</th>
                    <th>Is Complete</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${todos}" var="todo">
                <tr>
                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.done}</td>
                    <td><a href="deleteTodo?id=${todo.id}" class="btn btn-danger">Delete</a></td>
                    <td><a href="updateTodo?id=${todo.id}" class="btn btn-success">Update</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="addTodo" class="btn btn-success">Add Todo</a>
    </div>
</div>
<%@ include file="common/footer.jspf" %>

