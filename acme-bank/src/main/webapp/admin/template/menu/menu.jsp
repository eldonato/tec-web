<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="sidebar" data-color="purple" data-background-color="white" 
          data-image="${pageContext.request.contextPath}/assets/img/sidebar-1.jpg">
      <div class="logo"><a href="http://www.creative-tim.com" class="simple-text logo-normal">
          Creative Tim
        </a></div>
      <div class="sidebar-wrapper">
        <ul class="nav">
          <li class="nav-item active  ">
            <a class="nav-link" href="">
              <i class="material-icons">dashboard</i>
              <p>Dashboard</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="${pageContext.request.contextPath}/UsuariosServlet?acao=listar">
              <i class="material-icons">person</i>
              <p>Usuarios</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="${pageContext.request.contextPath}/ContatosServlet?acao=listar">
              <i class="material-icons">person</i>
              <p>Contatos</p>
            </a>
          </li>        
        </ul>
      </div>
    </div>
    