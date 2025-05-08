package com.example.backend_projeto_LuizAntonioCardoso_GabrielMilano.services;

import com.example.backend_projeto_LuizAntonioCardoso_GabrielMilano.entities.Estante;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class EstanteService {

    private final FirebaseService firebaseService;

    public EstanteService(FirebaseService firebaseService) {
        this.firebaseService = firebaseService;
    }

    public void criarEstante(String nome) {
        Estante estante = new Estante();
        estante.setId(UUID.randomUUID().toString());
        estante.setNome(nome);
        estante.setLivros(new ArrayList<>());
        firebaseService.salvarEstante(estante);
    }

    public void adicionarLivro(String idEstante, String isbn, int paginaAtual) {
        firebaseService.adicionarLivroNaEstante(idEstante, isbn, paginaAtual);
    }
}