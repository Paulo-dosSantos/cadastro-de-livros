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
		Livro livro1= new Livro("Coração negro", Genero.FANTASIA, LocalDate.of(2003, 05, 5), 4566, "x-mens viajam para um mundo alternativo para enfrentar seus maiores medos");
		livroRepository.save(livro1);
		
	}

}
