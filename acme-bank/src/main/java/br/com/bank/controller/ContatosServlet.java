package br.com.bank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bank.model.Contato;
import br.com.bank.service.ContatoServiceImpl;

/**
 * Servlet implementation class ContatoServlet
 */
@WebServlet("/contatosServlet")
public class ContatosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Contato contato;
	private ContatoServiceImpl service;

	public ContatosServlet() {
		this.service = new ContatoServiceImpl();
		this.contato = new Contato();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		switch (acao) {
		
		case "listar":
			RequestDispatcher rd = request.getRequestDispatcher("/admin/pages/contatos/list_contatos.jsp");
			request.setAttribute("contatos", this.service.list());
			rd.forward(request, response);
			break;
			
		case "remover":
			String id = request.getParameter("id");
			this.service.remover(Long.parseLong(id));
			RequestDispatcher rd1 = request.getRequestDispatcher("/ContatosServlet?acao=listar");
			request.setAttribute("remover", "Contato removido com sucesso");
			rd1.forward(request, response);
			break;

		case "getContatoById":
			String getId = request.getParameter("id");
			this.service.remover(Long.parseLong(getId));
			RequestDispatcher rd2 = request.getRequestDispatcher("/ContatosServlet?acao=listar");
			request.setAttribute("remover", "Contato removido com sucesso");
			rd2.forward(request, response);
			break;
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		switch (acao) {
		case "salvar":
			this.contato = new Contato();
			this.contato.setNome(request.getParameter("nome"));
			this.contato.setEmail(request.getParameter("email"));

			this.service.salvar(contato);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/pages/contatos/list_contatos.jsp");
			request.setAttribute("sucesso", "Contato " + contato.getNome() + "salvo com sucesso");
			request.setAttribute("contatos", this.service.list());
			rd.forward(request, response);

		case "editar":
			long id = Long.parseLong(request.getParameter("id"));

			this.contato = this.service.getContatoById(id);
			this.contato.setNome(request.getParameter("nome"));
			this.contato.setEmail(request.getParameter("email"));

			this.service.editar(contato);

			RequestDispatcher rd1 = request.getRequestDispatcher("/admin/pages/contatos/list_contatos.jsp");
			request.setAttribute("sucesso", "Contato " + contato.getNome() + " editada com sucesso.");
			request.setAttribute("contatos", this.service.list());
			rd1.forward(request, response);
			break;

		default:
			break;
		}
	}
}
