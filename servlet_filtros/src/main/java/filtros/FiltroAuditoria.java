package filtros;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter("/*")
public class FiltroAuditoria implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		System.out.println("FiltroSeguranca recebeu uma requisição");
		
		chain.doFilter(req, resp);
		
		System.out.println("FiltroAuditoria recebeu a resposta ");
	}
}
