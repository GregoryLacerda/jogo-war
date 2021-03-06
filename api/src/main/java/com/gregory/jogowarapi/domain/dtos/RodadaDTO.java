package com.gregory.jogowarapi.domain.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gregory.jogowarapi.domain.Rodada;

public class RodadaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private List<String> movimentoJogador = new ArrayList<>();
	private Integer partidaId;
	
	public RodadaDTO() {
		super();
	}

	public RodadaDTO(Integer id, List<String> movimentoJogador, Integer partidaId) {
		super();
		this.id = id;
		this.movimentoJogador = movimentoJogador;
		this.partidaId = partidaId;
	}
	
	public RodadaDTO(Rodada obj) {
		super();
		this.id = obj.getId();
		this.movimentoJogador = obj.getMovimentoJogador();
		this.partidaId = obj.getPartida().getCodigo();
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

	public void setMovimentoJogador(List<String> movimentoJogador) {
		this.movimentoJogador = movimentoJogador;
	}

	public Integer getPartida() {
		return partidaId;
	}

	public void setPartida(Integer partidaId) {
		this.partidaId = partidaId;
	}
	
}
