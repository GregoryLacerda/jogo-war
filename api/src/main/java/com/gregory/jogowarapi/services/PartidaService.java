package com.gregory.jogowarapi.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gregory.jogowarapi.domain.Jogador;
import com.gregory.jogowarapi.domain.Partida;
import com.gregory.jogowarapi.domain.Rodada;
import com.gregory.jogowarapi.domain.dtos.PartidaDTO;
import com.gregory.jogowarapi.repositories.JogadorRepository;
import com.gregory.jogowarapi.repositories.PartidaRepository;
import com.gregory.jogowarapi.repositories.RodadaRepository;
import com.gregory.jogowarapi.services.exceptions.ObjectNotFoundException;

@Service
public class PartidaService {
	
	@Autowired
	private PartidaRepository repository;
	@Autowired
	private RodadaRepository rodadaRepository;
	@Autowired
	private JogadorRepository jogadorRepository;
	
	public List<Partida> findAll() {
		
		List<Partida> list = repository.findAll();
		
		return list;
	}
	

	public Partida findById(Integer id) {
		
		Optional<Partida> obj = repository.findById(id);
		 
		return obj.orElseThrow(() -> new ObjectNotFoundException("Partida não encontrado"));
	}


	public Partida update(Integer id, PartidaDTO objDto) {
		
		objDto.setCodigo(id);
		Partida oldObj = findById(id);
		oldObj = newPartida(objDto);
		
		return repository.save(oldObj);
	}
	
	public Partida create(PartidaDTO objDto) {
		
		Partida newObj = newPartida(objDto);
		
		return newObj;
	}
	
	private Partida newPartida(PartidaDTO objDto) {
		
		List<Jogador> jogadores = jogadorRepository.findAllById(objDto.getJogadores());
		
		List<Rodada> rodadas = rodadaRepository.findAllById(objDto.getRodadas());
		
		Partida partida = new Partida();
		
		partida.setCodigo(null);
		partida.setVencedor(objDto.getVencedor());
		partida.addJogadores(jogadores);
		partida.addRodadas(rodadas);
		
		repository.save(partida);
		
		Set<Partida> partidas = new HashSet<>();
		
		partidas.add(partida);
		
		jogadores.forEach(obj -> obj.addPartidas(partidas));
		rodadas.forEach(obj -> obj.setPartida(partida));
		
		jogadorRepository.saveAll(jogadores);
		rodadaRepository.saveAll(rodadas);
		
		return partida;
	}
	
}
