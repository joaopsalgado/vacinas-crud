package br.com.vacinas.dao;

import br.com.vacinas.model.Alergia;
import br.com.vacinas.model.Usuario;
import br.com.vacinas.model.Vacina;

import java.util.List;
import java.util.Optional;

public interface IUsuarioDAO {

    Usuario save(Usuario user);
    void delete(Long id);
    List<Usuario> findAll();

    Usuario getById(Long id);

}
