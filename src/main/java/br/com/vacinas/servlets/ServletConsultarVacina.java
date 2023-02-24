package br.com.vacinas.servlets;

import br.com.vacinas.dao.AgendaDAO;
import br.com.vacinas.dao.VacinaDAO;
import br.com.vacinas.infra.ConnectionFactory;
import br.com.vacinas.model.Agenda;
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

@WebServlet("/consultarVacina")
public class ServletConsultarVacina extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        String idStr = request.getParameter("id");

        VacinaDAO vacinaDAO = new VacinaDAO(connection);

        Vacina vacina = vacinaDAO.getById(Long.valueOf(idStr));

        request.setAttribute("vacina", vacina);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/consultar-vacina.jsp");
        dispatcher.forward(request, response);

    }


}