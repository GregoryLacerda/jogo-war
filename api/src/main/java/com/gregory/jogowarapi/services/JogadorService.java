package com.gregory.jogowarapi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gregory.jogowarapi.domain.Jogador;
import com.gregory.jogowarapi.domain.dtos.JogadorDTO;
import com.gregory.jogowarapi.repositories.JogadorRepository;
import com.gregory.jogowarapi.services.exceptions.IllegalArgumentException;
import com.gregory.jogowarapi.services.exceptions.ObjectNotFoundException;

@Service
public class JogadorService {
	
	@Autowired
	private JogadorRepository repository;
	
	public List<JogadorDTO> findAll() {
		
		List<Jogador> list = repository.findAll();
		
		List<JogadorDTO> listDto = list.stream().map(obj -> new JogadorDTO(obj)).collect(Collectors.toList());
		
		return listDto;
	}
	
	
	public Jogador create(JogadorDTO objDto) {
	
		verificaNomeDuplicado(objDto);
		
		Jogador newObj = new Jogador(objDto);
		
		newObj.setId(null);
		newObj.setSoldadosLivres(10);		
		
		repository.save(newObj);
		
		return newObj;
	}


	public Jogador findById(Integer id) {
		
		Optional<Jogador> obj = repository.findById(id);
		 
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Jogador não encontrado"));
	}


	public Jogador update(Integer id, JogadorDTO objDto) {

		verificaNomeDuplicado(objDto);
		
		objDto.setId(id);
		Jogador oldObj = findById(id);
		oldObj = new Jogador(objDto);
		
		
		return repository.save(oldObj);
	}
	
	private void verificaNomeDuplicado(JogadorDTO objDto) {
		
		Jogador findObj = repository.findByNome(objDto.getNome());
		
		if (findObj != null && objDto.getNome().equals(findObj.getNome())) {
			throw new IllegalArgumentException("Nome de jogador já cadastrado");
		}
	}
}
