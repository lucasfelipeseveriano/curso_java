package com.softgraf.vendas;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/servletd", loadOnStartup = 3, 
	initParams = {
		@WebInitParam(name = "contato", value = "servletD@vendas.com"),
		@WebInitParam(name = "preco", value = "39,99")
})
public class ServletD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Iniciando ServletD");

		this.config = config;
		System.out.println(config.getInitParameter("contato"));
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();

		out.append("<h1>ServletD</h1>");
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
