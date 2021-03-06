package com.gregory.jogowarapi.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gregory.jogowarapi.domain.Jogador;
import com.gregory.jogowarapi.domain.Pais;
import com.gregory.jogowarapi.domain.Partida;
import com.gregory.jogowarapi.domain.Rodada;
import com.gregory.jogowarapi.repositories.JogadorRepository;
import com.gregory.jogowarapi.repositories.PaisRepository;
import com.gregory.jogowarapi.repositories.PartidaRepository;
import com.gregory.jogowarapi.repositories.RodadaRepository;

@Service
public class DBService {

	@Autowired
	private JogadorRepository jogadorRepository;
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private PartidaRepository partidaRepository;
	
	@Autowired
	private RodadaRepository rodadaRepository;
	
	public void instanciarDados() {
		
		Pais brasil = new Pais(null, "Brasil", 0, null);
		Pais chile = new Pais(null, "Chile", 0, null);
		Pais argentina = new Pais(null, "Argentina", 0, null);
		Pais uruguai = new Pais(null, "Uruguai", 0, null);
		
		brasil.addVizinhos(Arrays.asList(chile.getNome(), argentina.getNome(), uruguai.getNome()));
		argentina.addVizinhos(Arrays.asList(brasil.getNome(), chile.getNome(), uruguai.getNome()));
		chile.addVizinhos(Arrays.asList(brasil.getNome(), argentina.getNome(), uruguai.getNome()));
		uruguai.addVizinhos(Arrays.asList(brasil.getNome(), chile.getNome(), argentina.getNome()));
		
		paisRepository.saveAll(Arrays.asList(brasil, chile, argentina, uruguai));
		
		Jogador jogador1 = new Jogador(null, 10, "Jogador 1");
		Jogador jogador2 = new Jogador(null, 10, "Jogador 2");
		
		jogadorRepository.saveAll(Arrays.asList(jogador1, jogador2));
		
		jogador1.setPaises(new HashSet<>(Arrays.asList(brasil)));
		jogador2.setPaises(Set.copyOf(Arrays.asList(chile)));
		
		jogadorRepository.saveAll(Arrays.asList(jogador1, jogador2));
		
		brasil.setJogador(jogador1);
		chile.setJogador(jogador2);
		
		paisRepository.saveAll(Arrays.asList(brasil, chile));
		
		
		
		Partida ptd1 = new Partida(null, "Jogador 1");
		
		partidaRepository.save(ptd1);
		
		List<String> list = new ArrayList<>();
		
		list.addAll(Arrays.asList("Rodada 1", "Rodada 2"));
		
		Rodada rdd1 = new Rodada(null, list, ptd1); 
		
		rodadaRepository.saveAll(Arrays.asList(rdd1));
		
		Set<Partida> set = new HashSet<>();
		set.add(ptd1);
		
		jogador1.addPartidas(set);
		jogador2.addPartidas(set);
		
		jogadorRepository.saveAll(Arrays.asList(jogador1, jogador2));
		
		ptd1.addJogadores(Arrays.asList(jogador1, jogador2));
		ptd1.addRodadas(Arrays.asList(rdd1));
		
		partidaRepository.save(ptd1);
	}

}
