package br.com.vacinas.servlets;

import br.com.vacinas.dao.AlergiaDAO;
import br.com.vacinas.dao.UsuarioDAO;
import br.com.vacinas.infra.ConnectionFactory;
import br.com.vacinas.model.Alergia;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/removerUsuario")
public class ServletRemoverUsuario extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        String idStr = request.getParameter("id");

        UsuarioDAO usuarioDAO = new UsuarioDAO(connection);

        usuarioDAO.delete(Long.valueOf(idStr));

        response.sendRedirect("listarUsuarios");

    }

}
