        <%@ include file="common/header.jspf" %>
        <%@ include file="common/navigator.jspf" %>
        <div class="container">
            <h1>Welcome Back ${name}</h1>
            <form:form method="POST" class="form" modelAttribute="todo">
                <fieldset>
                    <form:label path="description">Description</form:label>
                    <form:input type="text" path="description"/>
                    <form:errors path="description" cssClass="text-danger"/>
                </fieldset>
                <br>
                <fieldset>
                    <form:label path="targetDate">Target Date</form:label>
                    <form:input type="date" path="targetDate"/>
                    <form:errors path="targetDate" cssClass="text-danger"/>
                </fieldset>

                <fieldset>
                    <form:label path="done">Is Done</form:label><br/>
                    <form:radiobutton path="done" value="true"/> True<br/>
                    <form:radiobutton path="done" value="false"/> False<br/>
                    <form:errors path="done" cssClass="text-danger"/>
                </fieldset>

                <form:input type="hidden" path="id"/>
                <form:input type="hidden" path="done"/>
                <br>
                <input type="submit" class="btn btn-success" />
            </form:form>
        </div>
        <script src="/webjars/jquery/4.0.0-beta/dist/jquery.min.js"></script>
    </body>
</html>
