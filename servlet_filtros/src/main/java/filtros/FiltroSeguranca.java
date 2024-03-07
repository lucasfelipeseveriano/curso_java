package filtros;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;


public class FiltroSeguranca extends HttpFilter implements Filter {


	@Override
	public void doFilter(jakarta.servlet.ServletRequest request, jakarta.servlet.ServletResponse response,
			jakarta.servlet.FilterChain chain) throws IOException, jakarta.servlet.ServletException {
		
		System.out.println("FiltroSeguranca recebeu uma requisição");
		
		chain.doFilter(request, response);
		
		System.out.println("FiltroSeguranca ");

	}
}
