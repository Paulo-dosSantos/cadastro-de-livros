package com.projeto_pessoal.com.api_rest_livros.entities;

import java.time.LocalDate;

import com.projeto_pessoal.com.api_rest_livros.entities.enums.Genero;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Livro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NonNull
	private String titulo;
	@NonNull
	private Genero genre;
	@NonNull
	private LocalDate dataDePublicacao;
	@NonNull
	private Integer isbn;
	@NonNull
	private String sumario;
	
	



}
