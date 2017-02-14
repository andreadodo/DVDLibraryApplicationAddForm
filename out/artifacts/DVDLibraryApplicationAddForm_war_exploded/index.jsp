<%--
  Created by IntelliJ IDEA.
  User: andrea
  Date: 07/02/17
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DVD Library Application</title>
</head>
<body>
    <h3>DVD Library Application Login</h3>

    <form action="login.do" method="post">
        <label>User:</label>
        <input type="text" name="user">
        <label>Password:</label>
        <input type="password" name="psw">
        <input type="submit" value="Login">
    </form>
    <%--<ul>
        <li><a href="list_library.view">Display my DVD library</a></li>
        <li><a href="formDvd.view">Add a DVD to my collection</a></li>
    </ul>--%>
</body>
</html>
