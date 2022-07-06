package com.iec.cbfapi.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "jogador")
public class Jogador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String pais;
    private String dataNascimento;
    private Integer idTime;

    public Jogador(){}

    public Jogador(Long id, String nome, String pais, String dataNascimento, Integer idTime) {
        this.id = id;
        this.nome = nome;
        this.pais = pais;
        this.dataNascimento = dataNascimento;
        this.idTime = idTime;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getIdTime() {
        return idTime;
    }

    public void setIdTime(Integer idTime) {
        this.idTime = idTime;
    }
}
