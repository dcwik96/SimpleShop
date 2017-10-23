package com.example.shop.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/formularz")
public class FormularzServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html; charset=UTF-8");
        httpServletResponse.setCharacterEncoding("UTF-8");

        PrintWriter out = httpServletResponse.getWriter();
    }
}
