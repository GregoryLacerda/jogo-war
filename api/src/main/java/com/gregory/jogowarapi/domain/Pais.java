package com.gregory.jogowarapi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pais implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	
	@ElementCollection(targetClass=String.class)
	private List<String> vizinhos = new ArrayList<>();
	
	private Integer soldadosDef;
	
	@JsonIgnore
	@ManyToOne
	private Jogador jogador;
	
	public Pais() {
		super();
	}
	
	public Pais(Integer id, String nome, Integer soldadosDef, Jogador jogador) {
		super();
		this.id = id;
		this.nome = nome;
		this.soldadosDef = soldadosDef;
		this.jogador = jogador;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<String> getVizinhos() {
		return vizinhos;
	}
 
	public void addVizinhos(List<String> vizinhos) {
		this.vizinhos.addAll(vizinhos);
	}

	public Integer getSoldadosDef() {
		return soldadosDef;
	}

	public void setSoldadosDef(Integer soldadosDef) {
		this.soldadosDef = soldadosDef;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		return Objects.equals(nome, other.nome);
	}
	
}
