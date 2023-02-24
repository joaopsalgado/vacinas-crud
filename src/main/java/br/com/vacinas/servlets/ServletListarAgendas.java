package br.com.vacinas.servlets;

import br.com.vacinas.dao.AgendaDAO;
import br.com.vacinas.dao.UsuarioDAO;
import br.com.vacinas.dao.VacinaDAO;
import br.com.vacinas.infra.ConnectionFactory;
import br.com.vacinas.model.Agenda;
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


@WebServlet(value = "/listarAgendas")
public class ServletListarAgendas extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        AgendaDAO dao = new AgendaDAO(connection);
        UsuarioDAO userDao = new UsuarioDAO(connection);
        VacinaDAO vacinaDao = new VacinaDAO(connection);

        List<Agenda> agendas = dao.findAll();

        for (Agenda agenda : agendas) {
            Long id_usuario = dao.getAgendaUsuario(agenda.getId());

            if(id_usuario > 0){
                Usuario usuarioAgenda = userDao.getById(id_usuario);
                agenda.setUsuario(usuarioAgenda);
            }


        }

        for(Agenda agenda : agendas){
            Long id_vacina = dao.getVacinaAgenda(agenda.getId());

            if(id_vacina > 0){
                Vacina vacinaAgenda = vacinaDao.getById(id_vacina);

                if(vacinaAgenda != null) {
                    agenda.setVacina(vacinaAgenda);
                }


            }


        }



        request.setAttribute("agendas", agendas);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/listar-agendas.jsp");
        dispatcher.forward(request, response);

    }


}
