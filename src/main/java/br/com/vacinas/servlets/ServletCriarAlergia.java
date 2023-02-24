package br.com.vacinas.servlets;

import br.com.vacinas.dao.AgendaDAO;
import br.com.vacinas.dao.AlergiaDAO;
import br.com.vacinas.infra.ConnectionFactory;
import br.com.vacinas.model.Agenda;
import br.com.vacinas.model.Alergia;
import br.com.vacinas.model.Situacao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/adicionarAlergia")
public class ServletCriarAlergia extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/adicionar-alergia.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        AlergiaDAO alergiaDAO = new AlergiaDAO(connection);

        String nome = request.getParameter("nome");

        Alergia alergia = new Alergia(null, nome);

        alergiaDAO.save(alergia);

        response.sendRedirect("listarAlergias");


    }

}
