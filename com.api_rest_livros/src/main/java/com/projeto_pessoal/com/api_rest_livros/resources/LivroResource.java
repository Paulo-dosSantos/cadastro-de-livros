package com.projeto_pessoal.com.api_rest_livros.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto_pessoal.com.api_rest_livros.entities.Livro;
import com.projeto_pessoal.com.api_rest_livros.services.LivroService;

@RestController
@RequestMapping(value="/livros")
public class LivroResource {
	
	@Autowired
	private LivroService servico;
	
	
	@GetMapping
	public ResponseEntity<List<Livro>> findAll(){
		List<Livro>livros= servico.findAll();
		
		return ResponseEntity.ok().body(livros);
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<Livro>findById(@PathVariable  int id){
		
		Livro livro= servico.findById(id);
		
		return ResponseEntity.ok().body(livro);
		
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void>delete(@PathVariable int id){
		
		servico.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	@PutMapping(value="/{id}")
	public ResponseEntity<Livro>update(@PathVariable int id, @RequestBody Livro livro){
		
		Livro novoLivro= servico.update(id, livro);
		
		return ResponseEntity.ok().body(novoLivro);
		
	}
	@PostMapping
	public ResponseEntity<Livro> insert(@RequestBody Livro livro) {
		
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(livro.getId()).toUri();
		return ResponseEntity.created(uri).body(servico.insert(livro));
		
	}

}
