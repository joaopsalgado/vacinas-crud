package br.com.vacinas.model;

import java.sql.Connection;

public class Vacina {
    private Long id;
    private String titulo;
    private String descricao;
    private int doses;
    private int periodicidade;
    private int intervalo;

    public Vacina(Long id, String titulo, String descricao, Integer doses, Integer periodicidade, Integer intervalo) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.doses = doses;
        this.periodicidade = periodicidade;
        this.intervalo = intervalo;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getDoses() {
        return doses;
    }

    public void setDoses(int doses) {
        this.doses = doses;
    }

    public int getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(int periodicidade) {
        this.periodicidade = periodicidade;
    }

    public int getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(int intervalo) {
        this.intervalo = intervalo;
    }
}
