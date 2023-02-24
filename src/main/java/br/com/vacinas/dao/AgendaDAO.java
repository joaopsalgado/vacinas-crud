package br.com.vacinas.dao;

import br.com.vacinas.model.Agenda;
import br.com.vacinas.model.Situacao;

import javax.swing.text.html.Option;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class AgendaDAO implements IAgendaDAO {

    private final Connection connection;

    public AgendaDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Agenda save(Agenda agenda) {

        try {
            String sql = "INSERT INTO Agenda (data, hora, situacao, observacoes) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setDate(1, java.sql.Date.valueOf(agenda.getData()));
            preparedStatement.setString(2, agenda.getHora());
            preparedStatement.setString(3, agenda.getSituacao().toString());
            preparedStatement.setString(4, agenda.getObservacoes());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            preparedStatement.close();
            resultSet.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return agenda;
    }

    @Override
    public List<Agenda> findAll() {
        String sql = "SELECT id, data, hora, situacao, data_situacao, observacoes FROM Agenda ORDER BY data";

        List<Agenda> agendas = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Long id = rs.getLong("id");
                LocalDate data = rs.getDate("data").toLocalDate();
                String hora = rs.getString("hora");
                Situacao situacao = Situacao.valueOf(rs.getString("situacao"));
                LocalDate data_situacao = rs.getDate("data_situacao") != null ? rs.getDate("data_situacao").toLocalDate() : null;
                String observacoes = rs.getString("observacoes");

                Agenda agenda = new Agenda(id, data, hora, situacao, data_situacao, observacoes);
                agendas.add(agenda);
            }

            preparedStatement.close();
            rs.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return agendas;
    }

    @Override
    public void delete(Long id) {
        try {
            String sql = "DELETE FROM Agenda WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Agenda getById(Long id) {
        try {

            String sql = "SELECT id, data, hora, situacao, data_situacao, observacoes FROM Agenda WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            rs.next();

            LocalDate data = rs.getDate("data").toLocalDate();
            String hora = rs.getString("hora");
            Situacao situacao = Situacao.valueOf(rs.getString("situacao"));
            LocalDate data_situacao = rs.getDate("data_situacao") != null ? rs.getDate("data_situacao").toLocalDate() : null;
            String observacoes = rs.getString("observacoes");

            Agenda agenda = new Agenda(id, data, hora, situacao, data_situacao, observacoes);

            preparedStatement.close();
            rs.close();

            return agenda;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Agenda update(Agenda agenda) {
        try {
            String sql = "UPDATE Agenda SET data_situacao = ?, situacao = ? WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, java.sql.Date.valueOf(agenda.getData_situacao()));
            preparedStatement.setString(2, Situacao.valueOf(agenda.getSituacao().toString()).toString());
            preparedStatement.setLong(3, agenda.getId());

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return agenda;
    }

    @Override
    public void saveAgendaUsuario(Long id_usuario, Long id_agenda) {

        try {
            String sql = "INSERT INTO Usuario_Agenda (id_usuario, id_agenda) VALUES (?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, id_usuario);
            preparedStatement.setLong(2, id_agenda);

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            preparedStatement.close();
            resultSet.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Long getAgendaInserida() {
        try {

            String sql = "SELECT MAX(id) as id FROM Agenda";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            rs.next();

            Long id = rs.getLong("id");


            preparedStatement.close();
            rs.close();

            return id;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Long getAgendaUsuario(Long id_agenda) {

        try {
            String sql = "SELECT id_usuario FROM Usuario_Agenda WHERE id_agenda = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id_agenda);

            ResultSet rs = preparedStatement.executeQuery();

            rs.next();

            Long id_usuario = 0L;

            if (rs.getRow() > 0) {
                id_usuario = rs.getLong("id_usuario");
            } else {
                id_usuario = 0L;
            }

            preparedStatement.close();
            rs.close();

            return id_usuario;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Long getVacinaAgenda(Long id_agenda) {

        try {
            String sql = "SELECT id_vacina FROM Vacina_Agenda WHERE id_agenda = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id_agenda);

            ResultSet rs = preparedStatement.executeQuery();

            rs.next();

            Long id_vacina = 0L;

            if (rs.getRow() > 0) {
                id_vacina = rs.getLong("id_vacina");
            } else {
                id_vacina = 0L;
            }


            preparedStatement.close();
            rs.close();

            return id_vacina;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void saveVacinaAgenda(Long id_vacina, Long id_agenda) {

        try {
            String sql = "INSERT INTO Vacina_Agenda (id_vacina, id_agenda) VALUES (?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, id_vacina);
            preparedStatement.setLong(2, id_agenda);

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            preparedStatement.close();
            resultSet.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


}
