package com.iec.cbfapi.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jogador")
public class Jogador implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String pais;
    private String dataNascimento;
    
    @ManyToOne
    @JoinColumn(name = "id_time")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Time time;
    
    @OneToMany(mappedBy = "jogadores")
    private List<Jogador> jogadores = new ArrayList<>();
    
    public Jogador(){}

    public Jogador(Long id, String nome, String pais, String dataNascimento, Time time) {
        this.id = id;
        this.nome = nome;
        this.pais = pais;
        this.dataNascimento = dataNascimento;
        this.time = time;
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

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
    
    
}
