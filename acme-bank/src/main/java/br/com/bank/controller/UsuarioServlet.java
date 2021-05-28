package br.com.bank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bank.model.Usuario;
import br.com.bank.service.UsuarioServiceImpl;

public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private UsuarioServiceImpl service;
       
    public UsuarioServlet() {
    	this.usuario = new Usuario();
    	this.service = new UsuarioServiceImpl();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		switch(acao) {
		
		case "remover":
			
			String id = request.getParameter("id");
			this.service.deleteById(Long.parseLong(id));
			RequestDispatcher rd = request.getRequestDispatcher("/usuariosServlet?acao=remover");
			request.setAttribute("remover", "Usuario " + usuario.getNome() + " removido com sucesso");
			rd.forward(request, response);
			break;
			
		case "editar":
			
			
		
		
		
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
