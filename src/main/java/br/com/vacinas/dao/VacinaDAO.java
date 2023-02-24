package br.com.vacinas.dao;

import br.com.vacinas.model.Vacina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacinaDAO implements IVacinaDAO {

    private final Connection connection;

    public VacinaDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Vacina save(Vacina vacina) {
        try {
            String sql = "INSERT INTO Vacina (titulo, descricao , doses, periodicidade, intervalo) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, vacina.getTitulo().toString());
            preparedStatement.setString(2, vacina.getDescricao());
            preparedStatement.setInt(3, vacina.getDoses());
            preparedStatement.setInt(4, vacina.getPeriodicidade());
            preparedStatement.setInt(5, vacina.getIntervalo());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            preparedStatement.close();
            resultSet.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return vacina;
    }

    @Override
    public void delete(Long id) {
        try {
            String sql = "DELETE FROM Vacina WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


    @Override
    public List<Vacina> findAll() {
        String sql = "SELECT id, titulo, descricao , doses, periodicidade, intervalo FROM Vacina";

        List<Vacina> vacinas = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                Long id = rs.getLong("id");
                String titulo = rs.getString("titulo");
                String descricao = rs.getString("descricao");
                Integer doses = rs.getInt("doses");
                Integer periodicidade = rs.getInt("periodicidade");
                Integer intervalo = rs.getInt("intervalo");

                Vacina vacina = new Vacina(id, titulo, descricao , doses, periodicidade, intervalo);
                vacinas.add(vacina);
            }

            preparedStatement.close();
            rs.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return vacinas;
    }

    @Override
    public Vacina getById(Long id) {
        try {

            String sql = "SELECT titulo, descricao , doses, periodicidade, intervalo FROM Vacina WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            rs.next();

            if(rs.getRow() > 0) {

                String titulo = rs.getString("titulo");
                String descricao = rs.getString("descricao");
                Integer doses = rs.getInt("doses");
                Integer periodicidade = rs.getInt("periodicidade");
                Integer intervalo = rs.getInt("intervalo");

                Vacina vacina = new Vacina(id, titulo, descricao , doses, periodicidade, intervalo);
                preparedStatement.close();

                return vacina;

            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
