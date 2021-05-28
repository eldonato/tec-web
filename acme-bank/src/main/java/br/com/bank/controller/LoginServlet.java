package br.com.bank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bank.model.Usuario;
import br.com.bank.service.UsuarioService;
import br.com.bank.service.UsuarioServiceImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioService userService;

	public LoginServlet() {
		this.userService = new UsuarioServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("admin/login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String pass = request.getParameter("password");

		List<Usuario> users = this.userService.list();

		for (int i = 0; i < users.size(); i++) {
			Usuario usuario = new Usuario();
			usuario = users.get(i);

			if (email.equals(usuario.getNome()) && pass.equals(usuario.getPassword())) {
				RequestDispatcher rd = request.getRequestDispatcher("admin/dashboard/index.jsp");
				break;
			}
		}
		if (email.equals("bruno@gmail.com") && pass.equals("123")) {

			RequestDispatcher rd = request.getRequestDispatcher("admin/dashboard/index.jsp");
			request.setAttribute("user", email);
			rd.forward(request, response);

		} else {

			RequestDispatcher rd = request.getRequestDispatcher("/admin/login.jsp");
			request.setAttribute("error", "Erro, login ou senha invalidos");
			rd.forward(request, response);
		}

	}

}
