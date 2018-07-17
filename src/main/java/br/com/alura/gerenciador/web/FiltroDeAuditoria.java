package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

//esse codigo insere um filtro espiao que guarda todas as paginas acessadas
//muito legal par auditoria - podemos usar na home?? ver depois 

@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		System.out.println("Usuário acessou: "+ uri);
		chain.doFilter(request, response);   // aqui ele retorma ao processamento do codigo normal
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
