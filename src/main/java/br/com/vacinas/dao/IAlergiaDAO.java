package br.com.vacinas.dao;

import br.com.vacinas.model.Agenda;
import br.com.vacinas.model.Alergia;

import java.util.List;

public interface IAlergiaDAO {

    Alergia save(Alergia alergia);


    void delete(Long id);

    List<Alergia> findAll();

    Alergia getById(Long id);
}
