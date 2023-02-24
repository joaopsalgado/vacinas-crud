package br.com.vacinas.dao;

import br.com.vacinas.model.Agenda;
import br.com.vacinas.model.Alergia;
import br.com.vacinas.model.Situacao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class AlergiaDAO implements IAlergiaDAO {

    private final Connection connection;

    public AlergiaDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Alergia save(Alergia alergia) {

        try {
            String sql = "INSERT INTO Alergia (nome) VALUES (?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, alergia.getNome());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            preparedStatement.close();
            resultSet.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return alergia;
    }

    @Override
    public void delete(Long id) {
        try {
            String sql = "DELETE FROM Alergia WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Alergia> findAll() {
        String sql = "SELECT id, nome FROM Alergia";

        List<Alergia> alergias = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                Long id = rs.getLong("id");
                String nome = rs.getString("nome");

                Alergia alergia = new Alergia(id, nome);
                alergias.add(alergia);
            }

            preparedStatement.close();
            rs.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return alergias;
    }

    @Override
    public Alergia getById(Long id) {
        try {

            String sql = "SELECT id, nome FROM Alergia WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            rs.next();

            String nome = rs.getString("nome");

            Alergia alergia = new Alergia(id, nome);

            preparedStatement.close();

            return alergia;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
