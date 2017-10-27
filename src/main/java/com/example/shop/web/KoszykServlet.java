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

@WebServlet("/koszyk")
public class KoszykServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html; charset=UTF-8");
        httpServletResponse.setCharacterEncoding("UTF-8");

        HttpSession session = httpServletRequest.getSession();
        StorageService koszykSession = (StorageService) session.getAttribute("koszykSess");
        StorageService appBooks = (StorageService) getServletContext().getAttribute("appBooks");

        PrintWriter out = httpServletResponse.getWriter();

        Map<Integer, Book> db = koszykSession.getAllBooks();

        if (httpServletRequest.getParameter("przedmiot") != null) {
            for (String ksiazka : httpServletRequest.getParameterValues("przedmiot")){
                Book koszykBook = appBooks.findBookById(Integer.parseInt(ksiazka));
                String tytul = koszykBook.getTitle();
                String autor = koszykBook.getAuthor();
                double cena = koszykBook.getPrize();
                int ilosc = koszykBook.getAmount();
                koszykSession.add(new Book(tytul, autor, cena, 1));
                appBooks.decreaseBook(new Book(tytul, autor, cena, ilosc));
            }
            db = koszykSession.getAllBooks();
        }

        out.println("<html><body><h3>Koszyk</h3>");
        for (Map.Entry<Integer, Book> entry : db.entrySet()) {
            out.println("'" + entry.getValue().getTitle() + "' by " + entry.getValue().getAuthor() + " for: " + entry.getValue().getPrize() + " " + entry.getValue().getAmount() + "<br />");
        }
        out.println("<form action='ksiazki'>" +
        				"<input type='submit' value='Wróć na stronę główną'/>" + 
        			"</form>");
        out.println("</body></html>");

        out.close();
    }
}
