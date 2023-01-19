<jsp:directive.include file="common/header.jspf"/>
<jsp:directive.include file="common/navigation.jspf"/>
        <div class="container">
            <hr>
            <h1>
                Your TODOS:
            </h1>
            <table class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Description</th>
                        <th>Target Date</th>
                        <th>Done?</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${todos}" var="todo">
                    <tr>
                        <td>${todo.id}</td>
                        <td>${todo.description}</td>
                        <td>${todo.targetDate}</td>
                        <td>${todo.done}</td>
                        <td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
                        <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="add-todo" class="btn btn-success">Add TODO</a>
        </div>

<jsp:directive.include file="common/footer.jspf"/>