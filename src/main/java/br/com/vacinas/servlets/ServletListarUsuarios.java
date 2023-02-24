package br.com.vacinas.servlets;

import br.com.vacinas.dao.AgendaDAO;
import br.com.vacinas.dao.AlergiaUsuarioDAO;
import br.com.vacinas.dao.UsuarioDAO;
import br.com.vacinas.infra.ConnectionFactory;
import br.com.vacinas.model.Agenda;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/listarUsuarios")
public class ServletListarUsuarios extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        UsuarioDAO dao = new UsuarioDAO(connection);
        AlergiaUsuarioDAO alergiaUsuarioDao = new AlergiaUsuarioDAO(connection);

        List<Usuario> usuarios = dao.findAll();
        List<AlergiaUsuario> listaAlergias = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            List<AlergiaUsuario> result = alergiaUsuarioDao.getAlergiasByUsuarioId(usuario.getId());
            listaAlergias.addAll(result);
        }

        request.setAttribute("listaAlergias", listaAlergias);
        request.setAttribute("usuarios", usuarios);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/listar-usuarios.jsp");
        dispatcher.forward(request, response);

    }


}
