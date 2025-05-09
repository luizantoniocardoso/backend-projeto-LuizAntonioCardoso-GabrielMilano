package com.example.backend_projeto_LuizAntonioCardoso_GabrielMilano.controller;

import com.example.backend_projeto_LuizAntonioCardoso_GabrielMilano.entities.Estante;
import com.example.backend_projeto_LuizAntonioCardoso_GabrielMilano.services.EstanteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            @RequestParam(required = false) Integer paginaAtual) {

        if (paginaAtual == null) {
            paginaAtual = 0;
        }

        estanteService.adicionarLivro(idEstante, isbn, paginaAtual);
        return ResponseEntity.ok("Livro adicionado à estante.");
    }

    @GetMapping("/buscar/{idEstante}")
    public Estante buscarEstantePorId(@PathVariable String idEstante){
        Estante estante = estanteService.buscarEstantePorId(idEstante);
        return estante;
    }

    @GetMapping("/buscar")
    public List<Estante> buscarTodasEstantes(){
        List<Estante> estantes = estanteService.buscarTodasEstantes();
        return estantes;
    }

    @PutMapping("/modificar/{idEstante}")
    public ResponseEntity<String> modificarEstante(
            @PathVariable String idEstante,
            @RequestParam(required = false) String tema,
            @RequestParam(required = false) String descricao) {

        estanteService.modificarEstante(idEstante, tema, descricao);
        return ResponseEntity.ok("Estante modificada com sucesso.");
    }

    @DeleteMapping("deletar/{idEstante}")
    public ResponseEntity<String> deletarEstantePorId(@PathVariable String idEstante){
        estanteService.deletarEstantePorId(idEstante);
        return ResponseEntity.ok("Estante Deletada com sucesso");
    }
}
