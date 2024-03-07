package servlet_autenticacao;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/index"})
@WebFilter("/*")
public class Autenticacao extends HttpServlet implements Filter{

	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("método doGet executado");
		req.getRequestDispatcher("/principal.html").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("\n=========> doFilter inicialo");
		
		String nome = req.getParameter("nome");
		String senha = req.getParameter("senha");
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		HttpSession session = request.getSession(false);
		
		if(session != null && session.getAttribute("login") != null) {
			chain.doFilter(req, resp);
		}
		
		else if (nome != null && nome.equalsIgnoreCase("lucas") &&
				senha != null && senha.equals("123")) {
			
			session = request.getSession(true);
			session.setAttribute("login", nome);
			chain.doFilter(req, resp);		
		} else {
			req.getRequestDispatcher("/logimn.html").forward(req, resp);
		}
		
		
		System.out.println("\n=========> doFilter finalizado");

	}
}
