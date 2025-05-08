package com.example.backend_projeto_LuizAntonioCardoso_GabrielMilano.entities;

import java.util.List;

public class Estante {
    private String id;
    private String nome;
    private String descricao;
    private String tema;
    private List<EstanteLivro> livros;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public List<EstanteLivro> getLivros() {
        return livros;
    }

    public void setLivros(List<EstanteLivro> livros) {
        this.livros = livros;
    }
}
