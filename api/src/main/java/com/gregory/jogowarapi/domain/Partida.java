package com.gregory.jogowarapi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Partida implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigo;
	
	@ManyToMany(mappedBy = "partidas")
	private List<Jogador> jogadores = new ArrayList<>();
	
	@OneToMany(mappedBy = "partida")
	private List<Rodada> rodadas = new ArrayList<>();
	
	private String vencedor;

	public Partida() {
		super();
	}

	public Partida(Integer codigo, List<Jogador> jogadores, List<Rodada> rodadas, String vencedor) {
		super();
		this.codigo = codigo;
		this.jogadores = jogadores;
		this.rodadas = rodadas;
		this.vencedor = vencedor;
	}
	
	public Partida(Integer codigo, String vencedor) {
		super();
		this.codigo = codigo;
		this.vencedor = vencedor;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void addJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public List<Rodada> getRodadas() {
		return rodadas;
	}

	public void addRodadas(List<Rodada> rodadas) {
		this.rodadas = rodadas;
	}

	public String getVencedor() {
		return vencedor;
	}

	public void setVencedor(String vencedor) {
		this.vencedor = vencedor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, jogadores, vencedor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partida other = (Partida) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(jogadores, other.jogadores)
				&& Objects.equals(vencedor, other.vencedor);
	}
}
