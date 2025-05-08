package com.example.backend_projeto_LuizAntonioCardoso_GabrielMilano.controller;

import com.example.backend_projeto_LuizAntonioCardoso_GabrielMilano.services.EstanteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estante")
public class EstanteController {

    private final EstanteService estanteService;

    public EstanteController(EstanteService estanteService) {
        this.estanteService = estanteService;
    }

    @PostMapping("/criar/{nome}")
    public ResponseEntity<String> criarEstante(@PathVariable String nome) {
        estanteService.criarEstante(nome);
        return ResponseEntity.ok("Estante criada com sucesso!");
    }

    @PostMapping("/{idEstante}/adicionar-livro/{isbn}")
    public ResponseEntity<String> adicionarLivro(
            @PathVariable String idEstante,
            @PathVariable String isbn,
            @RequestParam int paginaAtual) {

        estanteService.adicionarLivro(idEstante, isbn, paginaAtual);
        return ResponseEntity.ok("Livro adicionado à estante.");
    }
}
