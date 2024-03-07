package com.softgraf.vendas;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/index.html")
public class ServletE extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = getServletContext().getContextPath();
		System.out.println(path);
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		resp.getWriter().print("<h1>ServletE = Pagina Inicial</h1>");
		out.print("<a href='" + path + "/servleta'>ServletA</a><br>");
		out.print("<a href='" + path + "/servletb'>ServletB</a><br>");
		out.print("<a href='" + path + "/servletc'>ServletC</a><br>");
		out.print("<a href='" + path + "/servletd'>ServletD</a>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
}
