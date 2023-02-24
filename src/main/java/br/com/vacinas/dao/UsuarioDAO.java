package br.com.vacinas.dao;

import br.com.vacinas.model.Usuario;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements IUsuarioDAO {

    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Usuario save(Usuario user) {
        try {
            String sql = "INSERT INTO Usuario (nome, data_nascimento, sexo, logradouro, numero, setor, cidade, uf) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getNome().toString());
            preparedStatement.setDate(2, java.sql.Date.valueOf(user.getData_nascimento()));
            preparedStatement.setString(3, user.getSexo());
            preparedStatement.setString(4, user.getLogradouro());
            preparedStatement.setInt(5, user.getNumero());
            preparedStatement.setString(6, user.getSetor());
            preparedStatement.setString(7, user.getCidade());
            preparedStatement.setString(8, user.getUf());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            preparedStatement.close();
            resultSet.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return user;
    }


    @Override
    public void delete(Long id) {
        try {
            String sql = "DELETE FROM Usuario WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Usuario> findAll() {
            String sql = "SELECT id, nome, data_nascimento, sexo, logradouro, numero, setor, cidade, uf FROM usuario ORDER BY id";

            List<Usuario> usuarios = new ArrayList<>();

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {

                    Long id = rs.getLong("id");
                    String nome = rs.getString("nome");
                    LocalDate data_nascimento = rs.getDate("data_nascimento").toLocalDate();
                    String sexo = rs.getString("sexo");
                    String logradouro = rs.getString("logradouro");
                    Integer numero = rs.getInt("numero");
                    String setor = rs.getString("setor");
                    String cidade = rs.getString("cidade");
                    String uf = rs.getString("uf");

                    Usuario usuario = new Usuario(id, nome, data_nascimento, sexo, logradouro, numero, setor, cidade, uf);
                    usuarios.add(usuario);
                }

                preparedStatement.close();
                rs.close();

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            return usuarios;
        }

    @Override
    public Usuario getById(Long id) {
        try {

            String sql = "SELECT nome, data_nascimento, sexo, logradouro, numero, setor, cidade, uf FROM Usuario WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            rs.next();

            String nome = rs.getString("nome");
            LocalDate data_nascimento = rs.getDate("data_nascimento").toLocalDate();
            String sexo = rs.getString("sexo");
            String logradouro = rs.getString("logradouro");
            Integer numero = rs.getInt("numero");
            String setor = rs.getString("setor");
            String cidade = rs.getString("cidade");
            String uf = rs.getString("uf");


            Usuario usuario = new Usuario(id, nome, data_nascimento, sexo, logradouro, numero, setor, cidade, uf);

            preparedStatement.close();

            return usuario;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
