package com.example.backend_projeto_LuizAntonioCardoso_GabrielMilano.services;

import com.example.backend_projeto_LuizAntonioCardoso_GabrielMilano.entities.Estante;
import com.example.backend_projeto_LuizAntonioCardoso_GabrielMilano.entities.Livro;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FirebaseService {

    private final Firestore db = FirestoreClient.getFirestore();

    public void salvarLivro(Livro livro) {
        try {
            db.collection("livros").document(livro.getIsbn()).set(livro);
        }
        catch (Exception e){
            System.err.println("Erro ao salvar livro: " + e.getMessage());
        }
    }

    public void salvarEstante(Estante estante) {
        try{
            db.collection("estantes").document(estante.getId()).set(estante);
        }
        catch(Exception e){
            System.err.println("Erro ao salvar estante: " + e.getMessage());

        }
    }

    public List<Estante> buscarTodasEstantes(){
        List<Estante> estantes = new ArrayList<>();
        try {
            ApiFuture<QuerySnapshot> future = db.collection("estantes").get();
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            for(QueryDocumentSnapshot document : documents){
                Estante estante = document.toObject(Estante.class);
                estantes.add(estante);
            }
        }
        catch (Exception e){
            System.err.println("Erro ao buscar estantes: " + e.getMessage());
        }

        return estantes;
    }

    public Estante buscarEstantePorId(String idEstante){
        try{
            DocumentReference docRef = db.collection("estantes").document(idEstante);
            ApiFuture<DocumentSnapshot> future = docRef.get();
            DocumentSnapshot document = future.get();
            if(document.exists()){
                return document.toObject(Estante.class);
            }
            else {
                System.err.println("Estante com id: " + idEstante + " não encontrado");
            }
        }
        catch (Exception e){
            System.err.println("erro ao buscar estante: " + e.getMessage());
        }
        return null;
    }

    public List<Livro> pegarTodosLivros() {
        List<Livro> livros = new ArrayList<>();

        try {
            ApiFuture<QuerySnapshot> future = db.collection("livros").get();
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();

            for (QueryDocumentSnapshot document : documents) {
                Livro livro = document.toObject(Livro.class);
                livros.add(livro);
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar livros: " + e.getMessage());
        }

        return livros;
    }

    public Livro pegarLivroPorIsbn(String isbn) {
        try {
            DocumentReference docRef = db.collection("livros").document(isbn);
            ApiFuture<DocumentSnapshot> future = docRef.get();
            DocumentSnapshot document = future.get();

            if (document.exists()) {
                return document.toObject(Livro.class);
            } else {
                System.out.println("Livro com ISBN " + isbn + " não encontrado.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar livro: " + e.getMessage());
        }
        return null;
    }

    public void adicionarLivroNaEstante(String idEstante, String isbn, int paginaAtual) {
        DocumentReference estanteRef = db.collection("estantes").document(idEstante);
        Map<String, Object> livroNaEstante = new HashMap<>();
        livroNaEstante.put("isbn", isbn);
        livroNaEstante.put("paginaAtual", paginaAtual);

        try {
            ApiFuture<WriteResult> future = estanteRef.update("livros", FieldValue.arrayUnion(livroNaEstante));
            WriteResult result = future.get();
            System.out.println("Livro adicionado com sucesso à estante em: " + result.getUpdateTime());
        } catch (Exception e) {
            System.err.println("Erro ao adicionar livro à estante: " + e.getMessage());
        }
    }

    public void modificarEstante(String idEstante, String tema, String descricao) {
        DocumentReference estanteRef = db.collection("estantes").document(idEstante);

        Map<String, Object> atualizacoes = new HashMap<>();
        if (tema != null) {
            atualizacoes.put("tema", tema);
        }
        if (descricao != null) {
            atualizacoes.put("descricao", descricao);
        }

        try {
            ApiFuture<WriteResult> future = estanteRef.update(atualizacoes);
            WriteResult result = future.get();
            System.out.println("Estante atualizada com sucesso em: " + result.getUpdateTime());
        } catch (Exception e) {
            System.err.println("Erro ao modificar estante: " + e.getMessage());
        }
    }

    public void deletarEstantePorId(String idEstante) {
        try {
            ApiFuture<WriteResult> future = db.collection("estantes").document(idEstante).delete();
            WriteResult result = future.get();
            System.out.println("Estante deletada com sucesso em: " + result.getUpdateTime());
        } catch (Exception e) {
            System.err.println("Erro ao deletar estante: " + e.getMessage());
        }
    }

    public void deletarLivroPorIsbn(String idIsbn){
        try {
            ApiFuture<WriteResult> future = db.collection("livros").document(idIsbn).delete();
            WriteResult result = future.get();
            System.out.println("livro deletada com sucesso em: " + result.getUpdateTime());
        } catch (Exception e) {
            System.err.println("Erro ao deletar livro: " + e.getMessage());
        }
    }
}