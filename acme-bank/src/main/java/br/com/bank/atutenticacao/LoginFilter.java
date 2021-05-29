package br.com.bank.atutenticacao;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Passando pelo filtro de acesso....");
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		
		boolean taLogado = (session != null && session.getAttribute("email") != null);
		
		String urlLogin = httpRequest.getContextPath() + "/LoginServlet";
		
		
		boolean ehRequestLogin = httpRequest.getRequestURI().equals(urlLogin);
		boolean ehPaginaLogin = httpRequest.getRequestURI().endsWith("/admin/login.jsp");
		
		
		if(taLogado && (ehRequestLogin || ehPaginaLogin)) {
			
			RequestDispatcher dispacher = request.getRequestDispatcher("/admin/dashboard/index.jsp");
			dispacher.forward(request, response);
			
		}else if (taLogado || ehRequestLogin ) {
			chain.doFilter(request, response);
			
		} else {
			
			RequestDispatcher dispacher = request.getRequestDispatcher("/admin/login.jsp");
			dispacher.forward(request, response);
		}
		
	}

	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
