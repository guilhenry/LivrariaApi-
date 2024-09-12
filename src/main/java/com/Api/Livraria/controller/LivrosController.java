package com.Api.Livraria.controller;

import com.Api.Livraria.model.Livros;
import com.Api.Livraria.service.LivrariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/livros")
public class LivrosController {
    @Autowired
    private LivrariaService livrariaService;

    @GetMapping
    public ResponseEntity<List<Livros>> listarLivros(){
        List<Livros> livros = livrariaService.listaLivros();
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Livros> buscarPorId(@PathVariable Long id){
        Optional<Livros> livro = livrariaService.listaPorId(id);
        return livro.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public  ResponseEntity<Livros> criarLivro(@RequestBody Livros livro){
        Livros livroSalvo = livrariaService.addLivros(livro);
        return new ResponseEntity<>(livroSalvo, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Livros> atualizaLivro(@PathVariable Long id, @RequestBody Livros livro){
        if (!livrariaService.listaPorId(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
       livro.setId(id);
        Livros livroAtulizado = livrariaService.addLivros(livro);
        return ResponseEntity.ok(livroAtulizado);

    }
    @DeleteMapping
    public ResponseEntity<Void> removerLivro(@PathVariable Long id){
        if (!livrariaService.listaPorId(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        livrariaService.removerLivro(id);
        return ResponseEntity.noContent().build();
    }

}
