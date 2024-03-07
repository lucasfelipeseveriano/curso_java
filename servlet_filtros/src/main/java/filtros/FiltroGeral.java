package filtros;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class FiltroGeral implements Filter{
	
	private FilterConfig config;
		
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("FiltroGeral recebeu uma requisição e encaminhou para a Servlet");
		
		chain.doFilter(req, resp);
		
		System.out.println("FiltroGeral recebeu a resposta da Servlet");
		
	}
		
	@Override
	public void destroy() {
		System.out.println("FiltroGeral destroy");
		Filter.super.destroy();

	}

}
