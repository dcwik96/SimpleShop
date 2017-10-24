<%--
  Created by IntelliJ IDEA.
  User: dcwik
  Date: 24.10.17
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="koszykSess" class="com.example.shop.service.StorageService" scope="session" />

<%
    koszykSess.deleteAll();
    session.invalidate();
%>

<p>Dziekujemy za zakupy.</p>
</body>
</html>
