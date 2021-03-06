package com.gregory.jogowarapi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gregory.jogowarapi.domain.Jogador;
import com.gregory.jogowarapi.domain.Pais;
import com.gregory.jogowarapi.domain.dtos.PaisDTO;
import com.gregory.jogowarapi.repositories.JogadorRepository;
import com.gregory.jogowarapi.repositories.PaisRepository;
import com.gregory.jogowarapi.services.exceptions.ObjectNotFoundException;

@Service
public class PaisService {
	
	@Autowired
	private PaisRepository repository;
	@Autowired
	private JogadorRepository jogadorRepository;
	
	public List<PaisDTO> findAll() {
		
		List<Pais> list = repository.findAll();
		
		List<PaisDTO> listDto = list.stream().map(obj -> new PaisDTO(obj)).collect(Collectors.toList());
		
		return listDto;
	}
	

	public Pais findById(Integer id) {
		
		Optional<Pais> obj = repository.findById(id);
		 
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Pais não encontrado"));
	}


	public Pais update(Integer id, PaisDTO objDto) {
		
		objDto.setId(id);
		Pais oldObj = findById(id);
		oldObj = newPais(oldObj, objDto);
		
		
		return repository.save(oldObj);
	}
	
	private Pais newPais(Pais obj, PaisDTO objDto) {
		
		Jogador jogador = jogadorRepository.findByNome(objDto.getJogador());
		
		Pais pais = new Pais();
		
		pais.setId(obj.getId());
		pais.setNome(obj.getNome());
		pais.setJogador(jogador);
		pais.setSoldadosDef(objDto.getSoldadosDef());
		pais.addVizinhos(obj.getVizinhos());
		
		
		return pais;
	}
	
}
