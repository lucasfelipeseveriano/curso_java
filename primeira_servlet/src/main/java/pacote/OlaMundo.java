package pacote;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OlaMundo extends HttpServlet{
	private static final long serialVersionUID = 2338429199201107950L;
	
	@Override
	public void init() throws ServletException {
		// abrindo conexões com banco de dados
		super.init();	// necessário
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println("<h2>Bem Vindo: " + nome + " ao sistema </h2>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	// outros métodos: doHead(), doTrace(), doPut(), doDelete(), doOptions()
	
	@Override
	public void destroy() {
		// fechando conexões...
		System.out.println("Finalizando a servlet OlaMundo");
		super.destroy();
	}

}

