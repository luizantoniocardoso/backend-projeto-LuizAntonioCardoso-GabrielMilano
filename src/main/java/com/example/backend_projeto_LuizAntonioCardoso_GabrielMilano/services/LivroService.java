package com.example.backend_projeto_LuizAntonioCardoso_GabrielMilano.services;

import com.example.backend_projeto_LuizAntonioCardoso_GabrielMilano.entities.Livro;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LivroService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final FirebaseService firebaseService;

    public LivroService(FirebaseService firebaseService) {
        this.firebaseService = firebaseService;
    }

    public Livro buscarLivroPorIsbn(String isbn) {
        String url = "https://brasilapi.com.br/api/isbn/v1/" + isbn;
        Livro livro = restTemplate.getForObject(url, Livro.class);
        firebaseService.salvarLivro(livro);
        return livro;
    }
}
