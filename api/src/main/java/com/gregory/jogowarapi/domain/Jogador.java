package com.gregory.jogowarapi.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gregory.jogowarapi.domain.dtos.JogadorDTO;

@Entity
public class Jogador implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	private Integer soldadosLivres;
	
	@OneToMany(mappedBy = "jogador")
	private Set<Pais> paises = new HashSet<>();
	
	@JsonIgnore
	@ManyToMany
	private Set<Partida> partidas = new HashSet<>();
	
	public Jogador() {
		super();
	}

	public Jogador(Integer id, Integer soldadosLivres, String nome) {
		super();
		this.id = id;
		this.soldadosLivres = soldadosLivres;
		this.nome = nome;
	}

	public Jogador(JogadorDTO objDto) {
		setId(objDto.getId());
		setNome(objDto.getNome());
		setPaises(objDto.getPaises());
		setSoldadosLivres(objDto.getSoldadosLivres());
		addPartidas(objDto.getPartidas());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Pais> getPaises() {
		return paises;
	}

	public void setPaises(Set<Pais> paises) {
		this.paises = paises;
	}

	public Integer getSoldadosLivres() {
		return soldadosLivres;
	}

	public void setSoldadosLivres(Integer soldadosLivres) {
		this.soldadosLivres = soldadosLivres;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@JsonIgnore
	public Set<Partida> getPartidas() {
		return partidas;
	}

	public void addPartidas(Set<Partida> partidas) {
		this.partidas.addAll(partidas);
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
		Jogador other = (Jogador) obj;
		return Objects.equals(nome, other.nome);
	}
	
}
