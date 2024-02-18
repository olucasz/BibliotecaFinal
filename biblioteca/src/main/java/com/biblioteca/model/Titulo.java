package com.biblioteca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "titulo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Titulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    private int edicao;
    private int ano;
    private int prazo;
    // Construtores, getters e setters

}

