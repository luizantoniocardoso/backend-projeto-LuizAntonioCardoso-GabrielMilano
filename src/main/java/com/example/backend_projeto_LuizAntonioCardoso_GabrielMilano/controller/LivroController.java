package com.example.backend_projeto_LuizAntonioCardoso_GabrielMilano.controller;

import com.example.backend_projeto_LuizAntonioCardoso_GabrielMilano.entities.Livro;
import com.example.backend_projeto_LuizAntonioCardoso_GabrielMilano.services.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping("criar/{isbn}")
    public ResponseEntity<Livro> criarLivro(@PathVariable String isbn) {
        Livro livro = livroService.criarLivroPorIsbn(isbn);
        return ResponseEntity.ok(livro);
    }

    @GetMapping("buscar/{isbn}")
    public Livro buscarLivroPorIsbn(@PathVariable String isbn) {
        Livro livro = livroService.buscarLivroPorIsbn(isbn);
        return livro;
    }

    @GetMapping("buscar")
    public List<Livro> buscarTodosLivros(){
        List<Livro> livros = livroService.buscarTodosLivros();
        return livros;
    }

    @DeleteMapping("deletar/{isbn}")
    public void deletarLivroPorIsbn(@PathVariable String isbn) {
        livroService.deletarLivroPorIsbn(isbn);
    }

}
