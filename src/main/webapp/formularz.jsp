<%@ page import="com.example.shop.domain.Book" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: dcwik
  Date: 24.10.17
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:useBean id="koszykSess" class="com.example.shop.service.StorageService" scope="session" />
    <jsp:useBean id="person" class="com.example.shop.domain.Person" scope="session" />
    <%
        Map<Integer, Book> db = koszykSess.getAllBooks();

        double toPay = 0.0;
        int howManyBooks = 0;
        for (Map.Entry<Integer, Book> entry : db.entrySet()) {
            toPay += entry.getValue().getPrize();
            howManyBooks++;
        }
    %>
    <h3>Twoje zakupy wyniosły:  <%out.println(toPay);%> </h3><br />
    <p>Chcesz kupic <%out.println(howManyBooks);%> książki ?</p><br />
    <p>Wypełnij formularz i zatwierdz !</p><br />
    <form action='sprzedajKsiazki.jsp'>
        First name: <input type='text' name='firstName' value="${person.firstName}"/> <br />
        <input type="submit" value=" OK ">
    </form>
</body>
</html>
