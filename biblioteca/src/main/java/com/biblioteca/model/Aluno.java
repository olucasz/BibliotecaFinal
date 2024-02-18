package com.biblioteca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "aluno")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Aluno {
    @Id
    @Column(unique = true)
    private String matricula;

    private String nome;

    @Column(unique = true)
    private String cpf;

    private String endereco;
}
