package com.example.shop.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class Hello extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest arg0, HttpServletResponse resp) throws ServletException, IOException {
			PrintWriter out = resp.getWriter();
			out.println("Hello World! From my servlet");
		}
}
