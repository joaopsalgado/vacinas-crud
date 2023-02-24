package br.com.vacinas.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Agenda {

    private Long id;
    private LocalDate data;
    private String hora;
    private Situacao situacao;
    private LocalDate data_situacao;
    private String observacoes;
    private Usuario usuario;
    private Vacina vacina;

    public Agenda(Long id, LocalDate data, String hora, Situacao situacao, LocalDate dataSituacao, String observacoes) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.situacao = situacao;
        this.data_situacao = dataSituacao;
        this.observacoes = observacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public LocalDate getData_situacao() {
        return data_situacao;
    }

    public void setData_situacao(LocalDate data_situacao) {
        this.data_situacao = data_situacao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }
}
