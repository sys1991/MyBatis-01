<%--
  Created by IntelliJ IDEA.
  User: sys
  Date: 2016/5/18
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin index page</title>
</head>
<body>
<h1>ADMIN INDEX</h1>
<form action="/Admin" method="post">
    <input type="hidden" name="action" value="login"><br>
    <input type="text" name="email" placeholder="EMAIL"><br>
    <input type="password" name="password" placeholder="PASSWORD"><br>
    <input type="submit" value="LOGIN">
</form>


</body>
</html>
