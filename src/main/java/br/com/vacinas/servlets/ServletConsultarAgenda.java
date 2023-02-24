package br.com.vacinas.servlets;

import br.com.vacinas.dao.AgendaDAO;
import br.com.vacinas.dao.AlergiaDAO;
import br.com.vacinas.infra.ConnectionFactory;
import br.com.vacinas.model.Agenda;
import br.com.vacinas.model.Alergia;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/consultarAgenda")
public class ServletConsultarAgenda extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        String idStr = request.getParameter("id");

        AgendaDAO agendaDAO = new AgendaDAO(connection);

        Agenda agenda = agendaDAO.getById(Long.valueOf(idStr));

        request.setAttribute("agenda", agenda);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/consultar-agenda.jsp");
        dispatcher.forward(request, response);

    }


}