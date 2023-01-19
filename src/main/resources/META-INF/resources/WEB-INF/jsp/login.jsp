<jsp:directive.include file="common/header.jspf"/>
    <div class="container">
        <h1>Login</h1>
        <pre>
            ${errorMessage}
        </pre>
        <form method="post">
            Name: <input type="text" name="name">
            Password: <input type="text" name="pass">
            <input type="submit">
        </form>
    </div>
<jsp:directive.include file="common/footer.jspf"/>