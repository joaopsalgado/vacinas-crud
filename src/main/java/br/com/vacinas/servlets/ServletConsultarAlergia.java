package br.com.vacinas.servlets;

import br.com.vacinas.dao.AlergiaDAO;
import br.com.vacinas.dao.UsuarioDAO;
import br.com.vacinas.infra.ConnectionFactory;
import br.com.vacinas.model.Alergia;
import br.com.vacinas.model.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/consultarAlergia")
public class ServletConsultarAlergia extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        String idStr = request.getParameter("id");

        AlergiaDAO alergiaDAO = new AlergiaDAO(connection);

        Alergia alergia = alergiaDAO.getById(Long.valueOf(idStr));

        request.setAttribute("alergia", alergia);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/consultar-alergia.jsp");
        dispatcher.forward(request, response);

    }


}