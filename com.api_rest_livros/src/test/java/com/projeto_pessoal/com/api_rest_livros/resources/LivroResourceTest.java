package com.projeto_pessoal.com.api_rest_livros.resources;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.projeto_pessoal.com.api_rest_livros.entities.Livro;
import com.projeto_pessoal.com.api_rest_livros.entities.enums.Genero;
import com.projeto_pessoal.com.api_rest_livros.services.LivroService;

@SpringBootTest
class LivroResourceTest {
	
	@InjectMocks
	private LivroResource camadaDeRecurso;
	
	@Mock
	private LivroService camadaDeServico;
	
	private static final Integer ID=1;
	private static final String TITULO="O Senhor dos Anéis";
	private static final Genero GENERO=Genero.FANTASIA;
	private static final LocalDate DATA_DE_PUBLICACAO=LocalDate.of(1954, 7, 29);
	private static final String ISBN="1216";
	private static final String SUMARIO="Uma épica história de aventura em um mundo fantástico, onde um hobbit deve destruir um anel poderoso.";
	private Livro livro;
	private Livro novoLivro;

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
		novoLivro= new Livro("A Dança dos Dragões", Genero.FANTASIA, LocalDate.of(2005, 4, 12), "678345123", "Uma fantasia magnífica em um mundo cheio de mistérios e magia.");

		
	}

	@Test
	void findAll() {
		when(camadaDeServico.findAll()).thenReturn(List.of(livro));
		ResponseEntity<List<Livro>>livros= camadaDeRecurso.findAll();
		
		assertNotNull(livros);
		assertEquals(ResponseEntity.class, livros.getClass());
		assertEquals(Livro.class, livros.getBody().get(0).getClass());
		assertEquals(1,livros.getBody().size());
		assertEquals(TITULO,livros.getBody().get(0).getTitulo());
		assertEquals(GENERO,livros.getBody().get(0).getGenero());
		assertEquals(DATA_DE_PUBLICACAO,livros.getBody().get(0).getDataDePublicacao());
		assertEquals(ISBN,livros.getBody().get(0).getIsbn());
		assertEquals(SUMARIO,livros.getBody().get(0).getSumario());
	}
	@Test
	void findById() {
		when(camadaDeServico.findById(ID)).thenReturn(livro);
		
		ResponseEntity<Livro>retorno= camadaDeRecurso.findById(ID);
		assertNotNull(retorno);
		assertEquals(ID, retorno.getBody().getId());
		assertEquals(ResponseEntity.class, retorno.getClass());
		assertEquals(Livro.class, retorno.getBody().getClass());
		assertEquals(TITULO,retorno.getBody().getTitulo());
		assertEquals(GENERO,retorno.getBody().getGenero());
		assertEquals(DATA_DE_PUBLICACAO,retorno.getBody().getDataDePublicacao());
		assertEquals(ISBN,retorno.getBody().getIsbn());
		assertEquals(SUMARIO,retorno.getBody().getSumario());
	}
	@Test
	void update() {
		when(camadaDeServico.update(ID, novoLivro)).thenReturn(livro);
		ResponseEntity<Livro>retorno=camadaDeRecurso.update(ID, novoLivro);		
		assertNull(novoLivro.getId());
		assertNotNull(retorno);
		assertEquals(ResponseEntity.class,retorno.getClass());
		assertEquals(novoLivro.getTitulo(), retorno.getBody().getTitulo());
	}

}
