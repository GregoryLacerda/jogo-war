package com.gregory.jogowarapi.resources;

import java.net.URI;
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

import com.gregory.jogowarapi.domain.Jogador;
import com.gregory.jogowarapi.domain.dtos.JogadorDTO;
import com.gregory.jogowarapi.services.JogadorService;


@RestController
@RequestMapping(value = "/jogadores")
public class JogadorResource {
	
	
	@Autowired
	private JogadorService service;
	
	@GetMapping
	public ResponseEntity<List<JogadorDTO>> findAll(){
		
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<JogadorDTO> findById(@PathVariable Integer id) {
		
		JogadorDTO objDto = new JogadorDTO(service.findById(id));
		
		return ResponseEntity.ok().body(objDto);		
	}
	
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody JogadorDTO objDto){
		
		Jogador newObj = service.create(objDto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<JogadorDTO> update(@PathVariable Integer id, @RequestBody JogadorDTO objDto){
		
		Jogador obj = service.update(id, objDto);
		
		return ResponseEntity.ok().body(new JogadorDTO(obj));
	}
	
	

}










