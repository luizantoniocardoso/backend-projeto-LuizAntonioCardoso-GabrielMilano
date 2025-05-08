package com.example.backend_projeto_LuizAntonioCardoso_GabrielMilano.entities;

import java.time.LocalDateTime;

public class EstanteLivro {
    private String isbn;
    private int paginaAtual;
    private LocalDateTime dataAdicionado;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPaginaAtual() {
        return paginaAtual;
    }

    public void setPaginaAtual(int paginaAtual) {
        this.paginaAtual = paginaAtual;
    }

    public LocalDateTime getDataAdicionado() {
        return dataAdicionado;
    }

    public void setDataAdicionado(LocalDateTime dataAdicionado) {
        this.dataAdicionado = dataAdicionado;
    }
}
