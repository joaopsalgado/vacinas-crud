package br.com.vacinas.model;

public class AlergiaUsuario {
    private Long id_alergia;
    private Long id_usuario;
    private String nome_alergia;

    public AlergiaUsuario(Long id_alergia, Long id_usuario, String nome_alergia) {
        this.id_alergia = id_alergia;
        this.id_usuario = id_usuario;
        this.nome_alergia = nome_alergia;
    }

    public Long getId_alergia() {
        return id_alergia;
    }

    public void setId_alergia(Long id_alergia) {
        this.id_alergia = id_alergia;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome_alergia() {
        return nome_alergia;
    }
    public void setNome_alergia(String nome_alergia) {
        this.nome_alergia = nome_alergia;
    }
}
