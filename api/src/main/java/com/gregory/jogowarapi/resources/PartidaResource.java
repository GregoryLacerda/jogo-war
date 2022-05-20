package com.gregory.jogowarapi.resources;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gregory.jogowarapi.domain.Partida;
import com.gregory.jogowarapi.domain.dtos.PartidaDTO;
import com.gregory.jogowarapi.domain.dtos.RodadaDTO;
import com.gregory.jogowarapi.services.PartidaService;


@RestController
@RequestMapping(value = "/partidas")
public class PartidaResource {
	
	@Autowired
	private PartidaService service;
	
	@GetMapping
	public ResponseEntity<List<Partida>> findAll(){
		
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PartidaDTO> findById(@PathVariable Integer id) {
		
		PartidaDTO objDto = new PartidaDTO(service.findById(id));
		
		return ResponseEntity.ok().body(objDto);		
	}
	
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody PartidaDTO objDto){
		
		Partida newObj = service.create(objDto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PartidaDTO> update(@PathVariable Integer id, @RequestBody PartidaDTO objDto){
		
		Partida obj = service.update(id, objDto);
		
		return ResponseEntity.ok().body(new PartidaDTO(obj));
	}
	
	@PostMapping(value = "/addRodada")
	public ResponseEntity<Void> adicionarRodada(@RequestBody RodadaDTO objDTO){
		
		Partida partida = service.findById(objDTO.getPartida());
		
		partida.addRodadas(Arrays.asList(service.addRodada(objDTO)));
		
		return ResponseEntity.noContent().build();		
	}
	
	@PostMapping(value = "/{id}/addJogadores")
	public ResponseEntity<Void> adicionarJogador(@PathVariable Integer id, 
			@RequestBody List<Integer> jogadores){
		
		service.addJogadores(id, jogadores);
		
		return ResponseEntity.noContent().build();		
	}
	
	@PostMapping(value = "/{id}/setVencedor")
	public ResponseEntity<Void> setVencedor(@PathVariable Integer id, @RequestBody Integer idJogador){
		
		service.setVencedor(id, idJogador);
		
		return ResponseEntity.noContent().build();
	}

	
	
}










