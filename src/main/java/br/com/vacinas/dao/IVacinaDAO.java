package br.com.vacinas.dao;

import br.com.vacinas.model.Vacina;

import java.util.List;
import java.util.Optional;

public interface IVacinaDAO {

    Vacina save(Vacina vacina);
    void delete(Long id);
    List<Vacina> findAll();

    Vacina getById(Long id);
}
