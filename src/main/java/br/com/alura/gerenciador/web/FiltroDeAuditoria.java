package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
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

		   Cookie cookie = getUsuario(req);
		    String usuario = "<deslogado>";

		    if (cookie != null)
		        usuario = cookie.getValue();

		    System.out.println("Usuario " + usuario + " acessando a URI "
		            + req.getRequestURI());

		    chain.doFilter(request, response);   // aqui ele retorma ao processamento do codigo normal
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

private Cookie getUsuario(HttpServletRequest req) {

    Cookie[] cookies = req.getCookies();

    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("usuario.logado")) {
            return cookie;
        }
    }

    return null;
}
}