package com.gregory.jogowarapi.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gregory.jogowarapi.domain.Jogador;
import com.gregory.jogowarapi.domain.Partida;
import com.gregory.jogowarapi.domain.Rodada;
import com.gregory.jogowarapi.domain.dtos.JogadorDTO;
import com.gregory.jogowarapi.domain.dtos.PartidaDTO;
import com.gregory.jogowarapi.domain.dtos.RodadaDTO;
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
	@Autowired
	private JogadorService jogadorService;
	
	
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
	

	public void addJogadores(Integer idPartida, List<Integer> jogadores) {
		
		Partida partida = findById(idPartida);
		
		List<Jogador> jogador = jogadores.stream().map(obj -> {
			return new Jogador(new JogadorDTO(jogadorService.findById(obj)));			
		}).collect(Collectors.toList());
		
		
		jogador.stream().map(obj -> {
			obj.addPartidas(Set.copyOf(Arrays.asList(partida)));
			return obj;
			}).collect(Collectors.toList());
		
		jogadorRepository.saveAll(jogador);
		
		partida.addJogadores(jogador);
		
		repository.save(partida);
		
	}
	
	public Rodada addRodada(RodadaDTO objDTO) {
		
		Partida partida = findById(objDTO.getPartida());
		
		Rodada rodada = new Rodada();
		
		rodada.setId(objDTO.getId());
		rodada.setPartida(partida);
		rodada.addMovimentoJogador(objDTO.getMovimentoJogador());
		
		rodadaRepository.save(rodada);
		
		return rodada;
		
	}
	
	public void setVencedor(Integer idPartida, Integer idJogadorVencedor) {
		
		Partida partida = findById(idPartida);
		Jogador jogador = jogadorService.findById(idJogadorVencedor);
		
		partida.setVencedor(jogador.getNome());
		
		repository.save(partida);
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
