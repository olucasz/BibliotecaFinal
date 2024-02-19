package com.biblioteca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "livro")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean disponivel;
    private boolean exemplarBiblioteca;
    @ManyToOne
    @JoinColumn(name = "titulo_isbn", referencedColumnName = "isbn")
    private Titulo titulo;
    // Outros atributos e métodos getters/setters

    // Getters e Setters
}