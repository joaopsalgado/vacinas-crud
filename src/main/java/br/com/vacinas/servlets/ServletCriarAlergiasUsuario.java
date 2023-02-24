package br.com.vacinas.servlets;

import br.com.vacinas.dao.AlergiaDAO;
import br.com.vacinas.dao.AlergiaUsuarioDAO;
import br.com.vacinas.dao.UsuarioDAO;
import br.com.vacinas.infra.ConnectionFactory;
import br.com.vacinas.model.Alergia;
import br.com.vacinas.model.AlergiaUsuario;
import br.com.vacinas.model.Usuario;

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
import java.util.List;

@WebServlet("/adicionarAlergiasUsuario")
public class ServletCriarAlergiasUsuario extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            Connection connection = ConnectionFactory.getConnection();

            AlergiaDAO dao = new AlergiaDAO(connection);
            List<Alergia> alergias = dao.findAll();

            request.setAttribute("alergias", alergias);


            String idStr = request.getParameter("id");

            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
            Usuario usuario = usuarioDAO.getById(Long.valueOf(idStr));

            request.setAttribute("usuario", usuario);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/adicionar-alergias-usuario.jsp");
            dispatcher.forward(request, response);

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        AlergiaUsuarioDAO dao = new AlergiaUsuarioDAO(connection);

        String id_alergia = request.getParameter("alergia");
        String id_usuario = request.getParameter("usuario");

        AlergiaUsuario alergiaUsuario = new AlergiaUsuario(Long.valueOf(id_alergia), Long.valueOf(id_usuario), "");

        dao.saveAlergiasUsuario(alergiaUsuario);

        response.sendRedirect("listarUsuarios");

    }


}
