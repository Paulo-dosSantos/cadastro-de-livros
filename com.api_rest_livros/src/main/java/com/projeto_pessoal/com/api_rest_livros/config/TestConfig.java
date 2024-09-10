package com.projeto_pessoal.com.api_rest_livros.config;

import java.time.LocalDate;
import java.util.Arrays;

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
		Livro livro1= new Livro("O Senhor dos Anéis", Genero.FANTASIA, LocalDate.of(1954, 7, 29), "1216",
				"Uma épica história de aventura em um mundo fantástico, onde um hobbit deve destruir um anel poderoso.");
		livroRepository.save(livro1);
		
		Livro livro2 = new Livro("1984", Genero.FICCAO_CIENTIFICA, LocalDate.of(1949, 6, 8), "328", "Uma distopia sobre um regime totalitário que controla todos os aspectos da vida.");
		Livro livro3 = new Livro("Orgulho e Preconceito", Genero.ROMANCE, LocalDate.of(1813, 1, 28), "279", "Um clássico romance que explora questões de moralidade, educação e casamento na Inglaterra do século XIX.");
		Livro livro4 = new Livro("O Apanhador no Campo de Centeio", Genero.DRAMA, LocalDate.of(1951, 7, 16), "277", "A história de um adolescente rebelde em busca de identidade e propósito.");
		Livro livro5 = new Livro("Guerra e Paz", Genero.CLASSICO, LocalDate.of(1869, 1, 1), "1225", "Um retrato da sociedade russa durante as guerras napoleônicas.");
		Livro livro6 = new Livro("O Nome do Vento", Genero.FANTASIA, LocalDate.of(2007, 3, 27), "662", "As memórias de um herói lendário em um mundo de magia e mistério.");
		Livro livro7 = new Livro("Cem Anos de Solidão", Genero.FANTASIA, LocalDate.of(1967, 5, 30),"417", "A saga épica de uma família na fictícia cidade de Macondo.");
		Livro livro8 = new Livro("O Código Da Vinci", Genero.SUSPENSE, LocalDate.of(2003, 3, 18), "454", "Uma investigação cheia de mistérios e segredos ocultos em obras de arte famosas.");
		Livro livro9 = new Livro("Moby Dick", Genero.AVENTURA, LocalDate.of(1851, 11, 14), "635", "A obsessiva caça ao lendário e enorme cachalote branco.");
		Livro livro10 = new Livro("O Grande Gatsby", Genero.CLASSICO, LocalDate.of(1925, 4, 10), "180", "A história trágica de um homem e seu amor impossível na era do jazz.");

		livroRepository.saveAll(Arrays.asList(livro1,livro2,livro3,livro4,livro5,livro6,livro7,livro8,livro9,livro10));
	}

}
