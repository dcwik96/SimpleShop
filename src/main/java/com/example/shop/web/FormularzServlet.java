package com.example.shop.web;

import com.example.shop.domain.Book;
import com.example.shop.service.StorageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/formularz2")
public class FormularzServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html; charset=UTF-8");
        httpServletResponse.setCharacterEncoding("UTF-8");

        PrintWriter out = httpServletResponse.getWriter();

        HttpSession session = httpServletRequest.getSession();
        StorageService koszykSession = (StorageService) session.getAttribute("koszykSess");

        Map<Integer, Book> db = koszykSession.getAllBooks();

        double toPay = 0.0;
        int howManyBooks = 0;
        for (Map.Entry<Integer, Book> entry : db.entrySet()) {
            toPay += entry.getValue().getPrize();
            howManyBooks++;
        }

        out.println("<html><body><h3>Podsumowanie</h3>" +
                        "<h3>Twoje zakupy wyniosły: " + toPay + "</h3><br />" +
                        "<p>Chcesz kupic " + howManyBooks + " książki ?</p><br />" +
                        "<p>Wypełnij formularz i zatwierdz !</p><br />" +
                        "<form action='data'>" +
                        "First name: <input type='text' name='firstName' /> <br />" +
                        "Last name: <input type='text' name='lastName' /> <br />" +
                        "Phone number: <input type='text' name='phoneNumber''/> <br />" +
                    "</body></html>");
    }
}
