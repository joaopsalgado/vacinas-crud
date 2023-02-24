package br.com.vacinas.dao;
import br.com.vacinas.model.AlergiaUsuario;
import br.com.vacinas.model.Usuario;

import java.util.List;


public interface IAlergiaUsuarioDAO {

    AlergiaUsuario saveAlergiasUsuario(AlergiaUsuario alergiaUsuario);

    List<AlergiaUsuario> getAlergiasByUsuarioId(Long id);
}