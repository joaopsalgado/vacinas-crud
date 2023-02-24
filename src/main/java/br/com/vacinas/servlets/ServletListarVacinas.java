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
import java.util.List;

@WebServlet("/listarVacinas")
public class ServletListarVacinas extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        VacinaDAO dao = new VacinaDAO(connection);
        List<Vacina> vacinas = dao.findAll();

        request.setAttribute("vacinas", vacinas);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/listar-vacinas.jsp");
        dispatcher.forward(request, response);

    }


}
