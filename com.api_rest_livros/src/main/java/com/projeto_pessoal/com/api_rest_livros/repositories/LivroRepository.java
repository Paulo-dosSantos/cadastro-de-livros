package com.projeto_pessoal.com.api_rest_livros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto_pessoal.com.api_rest_livros.entities.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

}
