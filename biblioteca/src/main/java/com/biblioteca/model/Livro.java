package com.biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private boolean disponivel;
    private boolean exemplarBiblioteca;
    @ManyToOne
    @JoinColumn(name = "titulo_id", referencedColumnName = "id")
    private Titulo titulo;
    // Outros atributos e métodos getters/setters

    // Getters e Setters
    public boolean isDisponivel() {
        return disponivel;
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    public boolean isExemplarBiblioteca() {
        return exemplarBiblioteca;
    }
    public void setExemplarBiblioteca(boolean exemplarBiblioteca) {
        this.exemplarBiblioteca = exemplarBiblioteca;
    }
    public Titulo getTitulo() {
        return titulo;
    }
    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }
            
}