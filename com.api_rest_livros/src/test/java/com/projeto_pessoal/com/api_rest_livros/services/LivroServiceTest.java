package com.projeto_pessoal.com.api_rest_livros.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.projeto_pessoal.com.api_rest_livros.entities.Livro;
import com.projeto_pessoal.com.api_rest_livros.entities.enums.Genero;
import com.projeto_pessoal.com.api_rest_livros.repositories.LivroRepository;

@SpringBootTest
class LivroServiceTest {
	
	
	
	private static final Integer ID=1;
	private static final String TITULO="O Senhor dos Anéis";
	private static final Genero GENERO=Genero.FANTASIA;
	private static final LocalDate DATA_DE_PUBLICACAO=LocalDate.of(1954, 7, 29);
	private static final Integer ISBN=1216;
	private static final String SUMARIO="Uma épica história de aventura em um mundo fantástico, onde um hobbit deve destruir um anel poderoso.";
	private Livro livro;
	private Livro novoLivro;
	@Mock
	private LivroRepository repositorio;
	private Optional<Livro>livroOptional;
	@InjectMocks
	private LivroService servico;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		startUser();
	}

	private void startUser() {
		livro= new Livro(TITULO, GENERO, DATA_DE_PUBLICACAO, ISBN, SUMARIO);
		livro.setId(ID);
		livroOptional=Optional.of(livro);
		novoLivro= new Livro("A Dança dos Dragões", Genero.FANTASIA, LocalDate.of(2005, 4, 12), 678345123, "Uma fantasia magnífica em um mundo cheio de mistérios e magia.");
	}
	@Test
	void testFindAll() {
		when(repositorio.findAll()).thenReturn(List.of(livro));
		
		List<Livro>livros= servico.findAll();
		
		assertNotNull(ID);
		assertNotNull(TITULO);
		assertNotNull(GENERO);
		assertNotNull(DATA_DE_PUBLICACAO);
		assertNotNull(ISBN);
		assertNotNull(SUMARIO);
		assertEquals(1,livros.size());
		assertEquals(Livro.class,livros.get(0).getClass());
		
		assertEquals(ID, livros.get(0).getId());
		assertEquals(TITULO, livros.get(0).getTitulo());
		assertEquals(GENERO, livros.get(0).getGenero());
		assertEquals(DATA_DE_PUBLICACAO, livros.get(0).getDataDePublicacao());
		assertEquals(ISBN, livros.get(0).getIsbn());
		assertEquals(SUMARIO, livros.get(0).getSumario());
	}

	@Test
	void testFindById() {
		when(repositorio.findById(ID)).thenReturn(livroOptional);
		
		Livro livro= servico.findById(ID);
		assertNotNull(ID);
		
		assertNotNull(TITULO);
		assertNotNull(GENERO);
		assertNotNull(DATA_DE_PUBLICACAO);
		assertNotNull(ISBN);
		assertNotNull(SUMARIO);
		
		assertEquals(Livro.class,livro.getClass());
		
		assertEquals(ID, livro.getId());
		assertEquals(TITULO, livro.getTitulo());
		assertEquals(GENERO, livro.getGenero());
		assertEquals(DATA_DE_PUBLICACAO, livro.getDataDePublicacao());
		assertEquals(ISBN, livro.getIsbn());
		assertEquals(SUMARIO, livro.getSumario());
	}
		
	@Test
	void testDeleteById() {
		doNothing().when(repositorio).deleteById(ID);
		servico.deleteById(ID);
		verify(repositorio,times(1)).deleteById(ID);
	}
	@Test
	void update() {
		when(repositorio.getReferenceById(ID)).thenReturn(livro);
		when(repositorio.save(livro)).thenReturn(livro);
		
		Livro livro= servico.update(1, novoLivro);
		
		assertNotNull(ID);
		assertNull(novoLivro.getId());
		assertEquals(livro.getClass(),novoLivro.getClass());
		assertEquals(livro.getTitulo(),novoLivro.getTitulo());
		assertEquals(ID,livro.getId());
		assertEquals(livro.getDataDePublicacao(),novoLivro.getDataDePublicacao());
		assertEquals(livro.getIsbn(),novoLivro.getIsbn());
		assertEquals(livro.getGenero(),novoLivro.getGenero());
	
	}
	@Test
	void insert() {
		when(repositorio.save(livro)).thenReturn(livro);
		
		livro= servico.insert(livro);
		
		assertNotNull(ID);
		
		assertNotNull(TITULO);
		assertNotNull(GENERO);
		assertNotNull(DATA_DE_PUBLICACAO);
		assertNotNull(ISBN);
		assertNotNull(SUMARIO);
		
		assertEquals(Livro.class,livro.getClass());
		
		assertEquals(ID, livro.getId());
		assertEquals(TITULO, livro.getTitulo());
		assertEquals(GENERO, livro.getGenero());
		assertEquals(DATA_DE_PUBLICACAO, livro.getDataDePublicacao());
		assertEquals(ISBN, livro.getIsbn());
		assertEquals(SUMARIO, livro.getSumario());
	
		
	}

}
