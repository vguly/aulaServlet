package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/login")
public class Login extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        
        Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);

        if (usuario == null)  // usuario nao encontrado  
        	{
                writer.println("<html><body>Usuário ou senha inválida</body></html>");
            } else {
                writer.println("<html><body>Usuário logado: " + email
                        + "</body></html>");
            }        
	}
}
