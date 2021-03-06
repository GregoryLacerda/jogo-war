package com.gregory.jogowarapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gregory.jogowarapi.domain.Pais;
import com.gregory.jogowarapi.domain.dtos.PaisDTO;
import com.gregory.jogowarapi.services.PaisService;


@RestController
@RequestMapping(value = "/paises")
public class PaisResource {
	
	@Autowired
	private PaisService service;
	
	@GetMapping
	public ResponseEntity<List<PaisDTO>> findAll(){
		
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PaisDTO> findById(@PathVariable Integer id) {
		
		PaisDTO objDto = new PaisDTO(service.findById(id));
		
		return ResponseEntity.ok().body(objDto);		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PaisDTO> update(@PathVariable Integer id, @RequestBody PaisDTO objDto){
		
		Pais obj = service.update(id, objDto);
		
		return ResponseEntity.ok().body(new PaisDTO(obj));
	}
	
	

}










