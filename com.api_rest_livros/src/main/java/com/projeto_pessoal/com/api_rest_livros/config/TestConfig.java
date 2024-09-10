package com.projeto_pessoal.com.api_rest_livros.config;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projeto_pessoal.com.api_rest_livros.entities.Livro;
import com.projeto_pessoal.com.api_rest_livros.entities.enums.Genero;
import com.projeto_pessoal.com.api_rest_livros.repositories.LivroRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private LivroRepository livroRepository;

	@Override
	public void run(String... args) throws Exception {
		/*Alguns desses dados estarão errados, pois servem apenas para teste*/
		Livro livro1= new Livro("O Senhor dos Anéis", Genero.FANTASIA, LocalDate.of(1954, 7, 29), 1216, "Uma épica história de aventura em um mundo fantástico, onde um hobbit deve destruir um anel poderoso.");
		livroRepository.save(livro1);
		
	}

}
