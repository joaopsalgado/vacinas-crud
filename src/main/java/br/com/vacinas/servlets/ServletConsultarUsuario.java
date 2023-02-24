package br.com.vacinas.servlets;

import br.com.vacinas.dao.UsuarioDAO;
import br.com.vacinas.dao.VacinaDAO;
import br.com.vacinas.infra.ConnectionFactory;
import br.com.vacinas.model.Usuario;
import br.com.vacinas.model.Vacina;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/consultarUsuario")
public class ServletConsultarUsuario extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        String idStr = request.getParameter("id");

        UsuarioDAO usuarioDAO = new UsuarioDAO(connection);

        Usuario usuario = usuarioDAO.getById(Long.valueOf(idStr));

        request.setAttribute("usuario", usuario);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/consultar-usuario.jsp");
        dispatcher.forward(request, response);

    }


}