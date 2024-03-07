package com.softgraf.vendas;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletA extends HttpServlet {

	private static final long serialVersionUID = -5305798617524216472L;
	private ServletConfig config = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Iniciando ServletA");
		
		// lendo parâmetros de inicialização definidows em web.xml
		this.config = config;
		System.out.println(config.getInitParameter("contato"));
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// html, text, gif, jpg, png, pdf, zip,
		// text/html, test/plain, images/gif, images/jpeg, images/x-png
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
		// retorna para o navegador
		out.append("<h1>ServletA</h1>");
		out.append("<h3>Contato: " + config.getInitParameter("contato") + "</h3>");
		out.append("<h3>Preço: " + config.getInitParameter("preco") + "</h3>");
		out.flush();
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}

}
