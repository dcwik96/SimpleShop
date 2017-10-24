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

@WebServlet("/dodajKsiazke")
public class dodajKsiazkeServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html; charset=UTF-8");
        httpServletResponse.setCharacterEncoding("UTF-8");

        PrintWriter out = httpServletResponse.getWriter();

        out.println("<html><body><h3>Dodaj książkę</h3>" +
                "<form action='spis'>" +
                "Tytul: <input type='text' name='tytul' value=''/> <br />" +
                "Autor: <input type='text' name='autor' value=''/> <br />" +
                "Cena: <input type='text' name='cena' value='0.00'/> <br />" +
                "Ilość: <input type='text' name='ilosc' value='1'/> <br />" +
                "<button type='submit' name='dodaj'>Dodaj</button>" +
                "</form>" +
                "<form action='ksiazki'>" +
        				"<input type='submit' value='Wróć na stronę główną'/>" + 
        		"</form>" +
                "</body></html>");

        out.close();
    }
}
