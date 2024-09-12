package com.Api.Livraria.service;

import com.Api.Livraria.model.Livros;
import com.Api.Livraria.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivrariaService {

    @Autowired
    private LivrosRepository livrosRepository;

    public List<Livros> listaLivros(){
        return livrosRepository.findAll();
    }

    public Optional<Livros>listaPorId(Long id){
        return livrosRepository.findById(id);
    }

    public Livros addLivros(Livros livro){
        return livrosRepository.save(livro);
    }

    public void removerLivro(Long id){
        livrosRepository.deleteById(id);
    }

}
