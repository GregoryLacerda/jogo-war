package com.gregory.jogowarapi.domain.dtos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gregory.jogowarapi.domain.Jogador;
import com.gregory.jogowarapi.domain.Pais;
import com.gregory.jogowarapi.domain.Partida;

public class JogadorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Integer soldadosLivres;
	private Set<Pais> paises = new HashSet<>();
	@JsonIgnore
	private Set<Partida> partidas = new HashSet<>();
	
	public JogadorDTO() {
		super();
	}
	
	public JogadorDTO(Integer id, String nome, Integer soldadosLivres) {
		super();
		this.id = id;
		this.nome = nome;
		this.soldadosLivres = soldadosLivres;
	}

	public JogadorDTO(Jogador obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.soldadosLivres = obj.getSoldadosLivres();
		this.paises = obj.getPaises();
		this.partidas = obj.getPartidas();
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

	public Integer getSoldadosLivres() {
		return soldadosLivres;
	}

	public void setSoldadosLivres(Integer soldadosLivres) {
		this.soldadosLivres = soldadosLivres;
	}

	public Set<Pais> getPaises() {
		return paises;
	}

	public void setPaises(Set<Pais> paises) {
		this.paises = paises;
	}

	public Set<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(Set<Partida> partidas) {
		this.partidas = partidas;
	}
	
}
