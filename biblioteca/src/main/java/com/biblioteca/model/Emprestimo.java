package com.biblioteca.model;

import java.util.Date;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "emprestimo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataEmprestimo;
    private Date dataPrevista;
    private float multa;
    @OneToOne
    @Nullable
    private Devolucao devolucao;
    @ManyToOne
    private Aluno aluno;
    // Outros atributos e métodos getters/setters
    // Getters e Setters
    
}