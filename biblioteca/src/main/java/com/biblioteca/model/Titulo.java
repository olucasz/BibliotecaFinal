package com.biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Titulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    private int edicao;
    private int ano;
    private int prazo;

    // Construtores, getters e setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public int getEdicao() {
        return edicao;
    }
    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public int getPrazo() {
        return prazo;
    }
    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }
    
}

