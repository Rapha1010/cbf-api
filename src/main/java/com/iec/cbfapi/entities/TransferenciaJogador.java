package com.iec.cbfapi.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="transferencia_jogador")
public class TransferenciaJogador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long timeOrigem;
    private Long timeDestino;
    private String data;
    private float valor;

    public TransferenciaJogador() {}

    public TransferenciaJogador(Long id, Long timeOrigem, Long timeDestino, String data, float valor) {
        this.id = id;
        this.timeOrigem = timeOrigem;
        this.timeDestino = timeDestino;
        this.data = data;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTimeOrigem() {
        return timeOrigem;
    }

    public void setTimeOrigem(Long timeOrigem) {
        this.timeOrigem = timeOrigem;
    }

    public Long getTimeDestino() {
        return timeDestino;
    }

    public void setTimeDestino(Long timeDestino) {
        this.timeDestino = timeDestino;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
