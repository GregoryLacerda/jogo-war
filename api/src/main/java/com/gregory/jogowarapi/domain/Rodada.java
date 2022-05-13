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
public class Rodada implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ElementCollection(targetClass=String.class)
	private List<String> movimentoJogador = new ArrayList<>();
	
	@JsonIgnore
	@ManyToOne
	private Partida partida;
	
	public Rodada() {
		super();
	}

	public Rodada(Integer id, List<String> movimentoJogador, Partida partida) {
		super();
		this.id = id;
		this.movimentoJogador = movimentoJogador;
		this.partida = partida;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<String> getMovimentoJogador() {
		return movimentoJogador;
	}

	public void addMovimentoJogador(List<String> movimentoJogador) {
		this.movimentoJogador.addAll(movimentoJogador);
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, movimentoJogador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rodada other = (Rodada) obj;
		return Objects.equals(id, other.id) && Objects.equals(movimentoJogador, other.movimentoJogador);
	}
	
}
