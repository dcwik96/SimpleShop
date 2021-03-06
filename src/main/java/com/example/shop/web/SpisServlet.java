package com.example.shop.web;

import com.example.shop.domain.Book;
import com.example.shop.service.StorageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/spis")
public class SpisServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html; charset=UTF-8");
        httpServletResponse.setCharacterEncoding("UTF-8");

        PrintWriter out = httpServletResponse.getWriter();

        StorageService appBooks = (StorageService) getServletContext().getAttribute("appBooks");
        Map<Integer, Book> db = appBooks.getAllBooks();

        if (httpServletRequest.getParameter("dodaj") != null) {
            String tytul = httpServletRequest.getParameter("tytul");
            String autor = httpServletRequest.getParameter("autor");
            double cena = Double.parseDouble(httpServletRequest.getParameter("cena"));
            int ilosc = Integer.parseInt(httpServletRequest.getParameter("ilosc"));

            appBooks.add(new Book(tytul, autor, cena, ilosc));
        }
        db = appBooks.getAllBooks();
        out.println("<html><body><h3>Spis wszystkich książek</h3>" +
                    "   <form action='dodajKsiazke'><button value='dodaj'>Dodaj</button></form>" +
                    "   <form action='koszyk'>");
        for (Map.Entry<Integer, Book> entry : db.entrySet()) {
            out.println("'" + entry.getValue().getTitle() + "' by " + entry.getValue().getAuthor() + " for: " + entry.getValue().getPrize() + " " + entry.getValue().getAmount() + " left!" +
                        "   <input type='checkbox' name='przedmiot' value='" + entry.getKey() + "'> <br />");
        }
        out.println("       <button type='submit' name='kup'>Kup</button>" +
                    "   </form>" + "<br />" +
                    "   <form action='ksiazki'>" +
                    "       <input type='submit' value='Wróć na stronę główną'/>" +
        			"   </form>" +
                    "</body></html>");
        out.close();
    }
}
