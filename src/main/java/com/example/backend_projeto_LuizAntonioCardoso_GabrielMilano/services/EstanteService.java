package com.example.backend_projeto_LuizAntonioCardoso_GabrielMilano.services;

import com.example.backend_projeto_LuizAntonioCardoso_GabrielMilano.entities.Estante;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public List<Estante> buscarTodasEstantes(){
        List<Estante> estantes = firebaseService.buscarTodasEstantes();
        return estantes;
    }

    public Estante buscarEstantePorId(String idEstante){
        Estante estante = firebaseService.buscarEstantePorId(idEstante);
        return estante;
    }

    public void modificarEstante(String idEstante, String tema, String descricao){
        firebaseService.modificarEstante(idEstante,tema,descricao);
    }

    public void deletarEstantePorId(String idEstante){
        firebaseService.deletarEstantePorId(idEstante);
    }
}