<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/16
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>index page</title>
</head>
<body>
<h1>index</h1>
<form action="/student" method="post">
  <input type="hidden" name="action" value="login">
  <input type="text" name="email" placeholder="EMAIL" value="s1@qq.com"><br>
  <input type="password" name="password" placeholder="PASSWORD" value="123"><br>
  <input type="submit" value="登陆">
</form>
${requestScope.message}
<hr>
<a href="/student/sign_up.jsp">注册</a>
</body>
</html>