<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/16
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/inc.jsp" %>
<html>
<head>
    <title>student sign up page</title>
</head>
<body>
<h1>student sign up</h1>
<form action="/student" method="post">
    <input type="hidden" name="action" value="signUp">
    <input type="text" name="email" placeholder="EMAIL"><br>
    <input type="text" name="username" placeholder="USERNAME"><br>
    <input type="password" name="password" placeholder="PASSWORD"><br>
    <input type="file" name="photo" placeholder="PHOTO"><br>
    <select name="classId">
        <c:forEach var="aclass" items="${sessionScope.classes}">
            <option value="${aclass.id}">${aclass.name}</option>
        </c:forEach>
    </select><br>
    <input type="submit" value="STUDENT SIGN UP">
</form>
<hr>
</body>
</html>
