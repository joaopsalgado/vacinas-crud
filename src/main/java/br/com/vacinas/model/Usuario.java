package br.com.vacinas.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private Long id;
    private String nome;
    private LocalDate data_nascimento;
    private String sexo;
    private String logradouro;
    private Integer numero;
    private String setor;
    private String cidade;
    private String uf;
    private List<String> alergias = new ArrayList();

    public Usuario(Long id, String nome, LocalDate dataNascimento, String sexo, String logradouro, Integer numero, String setor, String cidade, String uf) {
      this.id  = id;
      this.nome = nome;
      this.data_nascimento = dataNascimento;
      this.sexo = sexo;
      this.logradouro = logradouro;
      this.numero = numero;
      this.setor = setor;
      this.cidade = cidade;
      this.uf = uf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public List<String> getAlergias() {return alergias;}

    public void setAlergias(String alergia) {
        this.alergias.add(alergia);
    }
}
