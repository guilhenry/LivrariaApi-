package com.Api.Livraria.repository;

import com.Api.Livraria.model.Livros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrosRepository extends JpaRepository<Livros,Long> {
}
