package br.com.vacinas.servlets;
import br.com.vacinas.dao.AgendaDAO;
import br.com.vacinas.dao.UsuarioDAO;
import br.com.vacinas.dao.VacinaDAO;
import br.com.vacinas.infra.ConnectionFactory;
import br.com.vacinas.model.Agenda;
import br.com.vacinas.model.Situacao;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
@WebServlet("/adicionarAgenda")
public class ServletCriarAgenda extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        UsuarioDAO dao = new UsuarioDAO(connection);
        VacinaDAO vacinaDAO = new VacinaDAO(connection);

        List < Usuario > usuarios = dao.findAll();
        List < Vacina > vacinas = vacinaDAO.findAll();

        request.setAttribute("usuarios", usuarios);
        request.setAttribute("vacinas", vacinas);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/adicionar-agenda.jsp");
        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = ConnectionFactory.getConnection();

        AgendaDAO agendaDAO = new AgendaDAO(connection);
        VacinaDAO vacinaDAO = new VacinaDAO(connection);

        String dataStr = request.getParameter("data");
        String hora = request.getParameter("hora");
        String situacaoStr = request.getParameter("situacao");
        String observacoes = request.getParameter("observacoes");
        String vacina_id = request.getParameter("vacina_id");
        String usuario_id = request.getParameter("usuario_id");

        Situacao situacao = Situacao.valueOf(situacaoStr);
        LocalDate data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Vacina vacina = vacinaDAO.getById(Long.parseLong(vacina_id));

        Agenda agenda = new Agenda(null, data, hora, situacao, null, observacoes);
        agendaDAO.save(agenda);

        agendaDAO.saveAgendaUsuario(Long.parseLong(usuario_id), agendaDAO.getAgendaInserida());
        agendaDAO.saveVacinaAgenda(Long.parseLong(vacina_id), agendaDAO.getAgendaInserida());

        for (Integer i = 1; i <= vacina.getDoses() - 1; i++) {

            Date novaData = this.convertToDateViaSqlDate(data);

            novaData = this.calcularData(vacina.getPeriodicidade(), vacina.getIntervalo(), novaData);

            data = this.convertToLocalDateViaSqlDate(novaData);

            agenda = new Agenda(null, data, hora, situacao, null, observacoes);
            agendaDAO.save(agenda);

            agendaDAO.saveAgendaUsuario(Long.parseLong(usuario_id), agendaDAO.getAgendaInserida());
            agendaDAO.saveVacinaAgenda(Long.parseLong(vacina_id), agendaDAO.getAgendaInserida());

        }

        response.sendRedirect("listarAgendas");
    }
    protected Date calcularData(Integer periodicidade, Integer intervalo, Date data) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);

        if (periodicidade == 1) {
            calendar.add(Calendar.DAY_OF_MONTH, intervalo);
            data = calendar.getTime();
        }

        if (periodicidade == 2) {
            calendar.add(Calendar.DAY_OF_WEEK, intervalo);
            data = calendar.getTime();
        }

        if (periodicidade == 3) {
            calendar.add(Calendar.MONTH, intervalo);
            data = calendar.getTime();
        }

        if (periodicidade == 4) {
            calendar.add(Calendar.YEAR, intervalo);
            data = calendar.getTime();
        }

        return data;
    }

    public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }
    public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }

}