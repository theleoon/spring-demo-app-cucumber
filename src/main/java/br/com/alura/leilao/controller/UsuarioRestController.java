package br.com.alura.leilao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.leilao.repositories.UsuarioRepository;

@RestController
@RequestMapping("/rest-usuario")
public class UsuarioRestController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listaTodos() {
		return new ResponseEntity<Object>(repository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> show(@PathVariable("id") Long usuarioId) {
		return new ResponseEntity<Object>(repository.getOne(usuarioId), HttpStatus.OK);
	}

}
