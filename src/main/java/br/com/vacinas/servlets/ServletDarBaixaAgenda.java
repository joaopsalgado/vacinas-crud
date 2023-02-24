package br.com.vacinas.servlets;

import br.com.vacinas.dao.AgendaDAO;
import br.com.vacinas.infra.ConnectionFactory;
import br.com.vacinas.model.Agenda;
import br.com.vacinas.model.Situacao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

@WebServlet("darBaixaAgenda")
public class ServletDarBaixaAgenda extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        String idStr = request.getParameter("id");

        AgendaDAO agendaDAO = new AgendaDAO(connection);

        Agenda agenda = agendaDAO.getById(Long.valueOf(idStr));

        request.setAttribute("agenda", agenda);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/dar-baixa-agenda.jsp");
        dispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        String idStr = request.getParameter("id");
        String dataSituacaoStr = request.getParameter("data_situacao");
        String situacaoStr = request.getParameter("situacao");

        LocalDate data = LocalDate.parse(dataSituacaoStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Situacao situacao = Situacao.valueOf(situacaoStr);

        AgendaDAO agendaDAO = new AgendaDAO(connection);

        Agenda agenda = agendaDAO.getById(Long.valueOf(idStr));
        agenda.setData_situacao(data);
        agenda.setSituacao(situacao);

        agendaDAO.update(agenda);

        response.sendRedirect("listarAgendas");


    }


}
