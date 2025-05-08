package com.example.backend_projeto_LuizAntonioCardoso_GabrielMilano.services;

import com.example.backend_projeto_LuizAntonioCardoso_GabrielMilano.entities.Estante;
import com.example.backend_projeto_LuizAntonioCardoso_GabrielMilano.entities.Livro;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

@Service
public class FirebaseService {

    private final Firestore db = FirestoreClient.getFirestore();

    public void salvarLivro(Livro livro) {
        db.collection("livros").document(livro.getIsbn()).set(livro);
    }

    public void salvarEstante(Estante estante) {
        db.collection("estantes").document(estante.getId()).set(estante);
    }

    public void adicionarLivroNaEstante(String idEstante, String isbn, int paginaAtual) {
        DocumentReference estanteRef = db.collection("estantes").document(idEstante);
        // buscar estante, adicionar livro e atualizar
    }
}