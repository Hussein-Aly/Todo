<jsp:directive.include file="common/header.jspf"/>
<jsp:directive.include file="common/navigation.jspf"/>
<div class="container">
    <hr>
    <h1>Enter TODO details</h1>
    <%--@elvariable id="todo" type="com.in28minutes.springboot.myfirstwebapp.todo.Todo"--%>
    <form:form method="post" modelAttribute="todo">

        <fieldset class="mb-3">
            <form:label path="description">Description</form:label>
            <form:input type="text" name="description" required="required" path="description"/>
            <form:errors path="description" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="targetDate">Target Date</form:label>
            <form:input type="text" path="targetDate" required="required"/>
            <form:errors path="targetDate" cssClass="text-warning"/>
        </fieldset>


        <form:input type="hidden" path="id"/>
        <form:input type="hidden" path="done"/>
        <form:input type="hidden" path="name"/>
        <input type="submit" class="btn btn-success">


    </form:form>
</div>
<jsp:directive.include file="common/footer.jspf"/>