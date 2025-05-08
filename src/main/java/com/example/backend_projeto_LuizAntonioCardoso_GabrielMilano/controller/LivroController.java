package com.example.backend_projeto_LuizAntonioCardoso_GabrielMilano.controller;

import com.example.backend_projeto_LuizAntonioCardoso_GabrielMilano.entities.Livro;
import com.example.backend_projeto_LuizAntonioCardoso_GabrielMilano.services.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/criar/biblioteca/livro")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping("/{isbn}")
    public ResponseEntity<Livro> criarLivro(@PathVariable String isbn) {
        Livro livro = livroService.buscarLivroPorIsbn(isbn);
        System.out.println("teste map");
        return ResponseEntity.ok(livro);
    }
}
