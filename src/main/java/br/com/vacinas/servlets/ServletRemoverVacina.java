package br.com.vacinas.servlets;

import br.com.vacinas.dao.UsuarioDAO;
import br.com.vacinas.dao.VacinaDAO;
import br.com.vacinas.infra.ConnectionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/removerVacina")
public class ServletRemoverVacina extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        String idStr = request.getParameter("id");

        VacinaDAO vacinaDAO = new VacinaDAO(connection);

        vacinaDAO.delete(Long.valueOf(idStr));

        response.sendRedirect("listarVacinas");

    }

}