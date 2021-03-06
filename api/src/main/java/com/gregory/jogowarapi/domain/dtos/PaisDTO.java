package com.gregory.jogowarapi.domain.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gregory.jogowarapi.domain.Pais;

public class PaisDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private List<String> vizinhos = new ArrayList<>();
	private Integer soldadosDef;
	private String nomeJogador;
	
	public PaisDTO() {
		super();
	}

	public PaisDTO(Integer id, String nome, List<String> vizinhos, Integer soldadosDef, String nomeJogador) {
		super();
		this.id = id;
		this.nome = nome;
		this.vizinhos = vizinhos;
		this.soldadosDef = soldadosDef;
		this.nomeJogador = nomeJogador;
	}
	
	public PaisDTO(Pais obj) {
		super();
		setId(obj.getId());
		setNome(obj.getNome());
		if (obj.getJogador() != null) {
			setJogador(obj.getJogador().getNome());			
		}
		setVizinhos(obj.getVizinhos());
		setSoldadosDef(obj.getSoldadosDef());
		
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

	public void setVizinhos(List<String> vizinhos) {
		this.vizinhos = vizinhos;
	}

	public Integer getSoldadosDef() {
		return soldadosDef;
	}

	public void setSoldadosDef(Integer soldadosDef) {
		this.soldadosDef = soldadosDef;
	}

	public String getJogador() {
		return nomeJogador;
	}

	public void setJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}

}
