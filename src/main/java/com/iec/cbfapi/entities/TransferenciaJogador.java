package com.iec.cbfapi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name="transferencia_jogador")
public class TransferenciaJogador implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_time_origem")
    private Time timeOrigem;
    
    @ManyToOne
    @JoinColumn(name = "id_time_destino")
    private Time timeDestino;
    
    @ManyToOne
    @JoinColumn(name = "id_jogador")
    private Jogador jogador;
    
    private Instant data = Instant.now();
    private float valor;
    
    public TransferenciaJogador() {}

    public TransferenciaJogador(Long id, Jogador jogador, Time timeOrigem, Time timeDestino, float valor) {
        this.id = id;
        this.jogador = jogador;
        this.timeOrigem = timeOrigem;
        this.timeDestino = timeDestino;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public Time getTimeOrigem() {
        return timeOrigem;
    }

    public void setTimeOrigem(Time timeOrigem) {
        this.timeOrigem = timeOrigem;
    }

    public Time getTimeDestino() {
        return timeDestino;
    }

    public void setTimeDestino(Time timeDestino) {
        this.timeDestino = timeDestino;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
