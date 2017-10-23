package com.example.shop.web;


import com.example.shop.domain.Book;
import com.example.shop.service.KoszykService;
import com.example.shop.service.StorageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@WebServlet("/ksiazki")
public class BookServlet extends HttpServlet{

    @Override
    public void init() throws ServletException {
        getServletContext().setAttribute("appBooks", new StorageService());
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html; charset=UTF-8");
        httpServletResponse.setCharacterEncoding("UTF-8");

        HttpSession session = httpServletRequest.getSession();

        PrintWriter out = httpServletResponse.getWriter();


        out.println("<html><body><h2>Witaj w sklepie z książkami</h2>");
        out.println(    "<p><a href='spis'>Spis książek</a></p>" +
                        "<p><a href='formularz'>Formularz zakupowy</a></p>" +
                        "<p><a href='koszyk'>Koszyk</a></p>" +
                        "</body></html>");

        if (session.getAttribute("koszykSess") == null) {
            session.setAttribute("koszykSess", new KoszykService());
        }









        //        StorageService storageService = new StorageService();
//        Book book = new Book("Jakas", "Jakis", 10.0, 2);
//        storageService.add(book);
//
//        Map<Book, Integer> books = storageService.getAllBooks();
//
//        out.println("czesc");
//
//        out.println(books.containsKey(1));
        out.close();
    }
}
