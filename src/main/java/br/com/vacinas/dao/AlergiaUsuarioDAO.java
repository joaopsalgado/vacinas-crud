package br.com.vacinas.dao;

import br.com.vacinas.model.AlergiaUsuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlergiaUsuarioDAO implements IAlergiaUsuarioDAO {
    private final Connection connection;
    public AlergiaUsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public AlergiaUsuario saveAlergiasUsuario(AlergiaUsuario alergiaUsuario) {
        try {

            String sql = "INSERT INTO Alergia_Usuarios (id_alergia, id_usuario) VALUES (?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, alergiaUsuario.getId_alergia());
            preparedStatement.setLong(2, alergiaUsuario.getId_usuario());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            preparedStatement.close();
            resultSet.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return alergiaUsuario;
    }

    @Override
    public List<AlergiaUsuario> getAlergiasByUsuarioId(Long id) {

            String sql = "SELECT Alergia_Usuarios.id_usuario, Alergia_Usuarios.id_alergia, Alergia.nome" +
                            " FROM Alergia_Usuarios" +
                            " INNER JOIN Alergia on Alergia.id = id_alergia" +
                            " WHERE Alergia_Usuarios.id_usuario = ?";

            List<AlergiaUsuario> alergiasUsuarios = new ArrayList<>();

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, id);

                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    String nome = rs.getString("nome");
                    Long id_usuario = rs.getLong("id_usuario");
                    Long id_alergia = rs.getLong("id_alergia");

                    AlergiaUsuario alergiaUsuario = new AlergiaUsuario(id_alergia, id_usuario, nome);
                    alergiasUsuarios.add(alergiaUsuario);
                }

                preparedStatement.close();
                rs.close();

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            return alergiasUsuarios;
    }
}
