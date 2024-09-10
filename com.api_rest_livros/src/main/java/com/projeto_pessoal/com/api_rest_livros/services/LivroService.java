package com.projeto_pessoal.com.api_rest_livros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto_pessoal.com.api_rest_livros.entities.Livro;
import com.projeto_pessoal.com.api_rest_livros.repositories.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repositorio;
	
	
	public List<Livro>findAll(){
		List<Livro>livros= repositorio.findAll();
		
		return livros;
	}
	public Livro findById(Integer id) {
		Livro livro= repositorio.findById(id).get();
		
		return livro;
	}
	public void deleteById(Integer id) {
		repositorio.deleteById(id);
	}
	public Livro update(int id, Livro novoLivro) {
		Livro livro= repositorio.getReferenceById(id);
		updateData(livro,novoLivro);
		livro.setId(id);
		return repositorio.save(livro);
	}
	private void updateData(Livro livro, Livro novoLivro) {
		livro.setTitulo(novoLivro.getTitulo());
		livro.setSumario(novoLivro.getSumario());
		livro.setIsbn(novoLivro.getIsbn());
		livro.setGenero(novoLivro.getGenero());
		livro.setDataDePublicacao(novoLivro.getDataDePublicacao());
		
	}
	public Livro insert(Livro livro) {
		return repositorio.save(livro);
	}
}
