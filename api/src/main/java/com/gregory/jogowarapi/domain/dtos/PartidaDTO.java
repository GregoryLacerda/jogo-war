package com.gregory.jogowarapi.domain.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.gregory.jogowarapi.domain.Partida;

public class PartidaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	private List<Integer> jogadores = new ArrayList<>();
	private List<Integer> rodadas = new ArrayList<>();
	private String vencedor;
	
	public PartidaDTO() {
		super();
	}

	public PartidaDTO(Integer codigo, List<Integer> jogadores, List<Integer> rodadas, String vencedor) {
		super();
		this.codigo = codigo;
		this.jogadores = jogadores;
		this.rodadas = rodadas;
		this.vencedor = vencedor;
	}
	
	public PartidaDTO(Partida obj) {
		super();
		setCodigo(obj.getCodigo());
		setJogadores(obj.getJogadores().stream().map(id -> id.getId()).collect(Collectors.toList()));
		setRodadas(obj.getRodadas().stream().map(id -> id.getId()).collect(Collectors.toList()));
		setVencedor(obj.getVencedor());
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public List<Integer> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Integer> jogadores) {
		this.jogadores = jogadores;
	}

	public List<Integer> getRodadas() {
		return rodadas;
	}

	public void setRodadas(List<Integer> rodadas) {
		this.rodadas = rodadas;
	}

	public String getVencedor() {
		return vencedor;
	}

	public void setVencedor(String vencedor) {
		this.vencedor = vencedor;
	}
}
