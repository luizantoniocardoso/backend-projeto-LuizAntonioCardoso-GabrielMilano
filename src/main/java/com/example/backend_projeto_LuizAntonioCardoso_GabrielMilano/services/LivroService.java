package com.example.backend_projeto_LuizAntonioCardoso_GabrielMilano.services;

import com.example.backend_projeto_LuizAntonioCardoso_GabrielMilano.entities.Livro;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class LivroService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final FirebaseService firebaseService;

    public LivroService(FirebaseService firebaseService) {
        this.firebaseService = firebaseService;
    }

    public Livro criarLivroPorIsbn(String isbn){
        Livro livro = buscarNaApiLivroPorIsbn(isbn);
        firebaseService.salvarLivro(livro);
        return livro;
    }

    public Livro buscarNaApiLivroPorIsbn(String isbn) {
        String url = "https://brasilapi.com.br/api/isbn/v1/" + isbn;
        Livro livro = restTemplate.getForObject(url, Livro.class);
        return livro;
    }

    public Livro buscarLivroPorIsbn(String isbn){
        Livro livro = firebaseService.pegarLivroPorIsbn(isbn);
        return livro;
    }

    public List<Livro> buscarTodosLivros () {
        List<Livro> livros = firebaseService.pegarTodosLivros();
        return livros;
    }

    public void deletarLivroPorIsbn (String isbn){
        firebaseService.deletarLivroPorIsbn(isbn);
    }
}
