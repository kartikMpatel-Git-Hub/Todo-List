<html>
    <head>
        <title>Login Page</title>
        <link href="/webjars/bootstrap/5.3.7/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Welcome TO login Page</h1>
            <form method="POST">
                Name : <input type="text" name="name">
                Password : <input type="password" name="password">
                <input type="submit" class="btn btn-success">
            </from>
            <pre style="color:red;">${error}</pre>
        </div>
    </body>
</html>