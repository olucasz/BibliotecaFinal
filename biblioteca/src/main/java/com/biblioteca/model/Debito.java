package com.biblioteca.model;

import jakarta.persistence.*;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "debito")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Debito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int valor;
    private Date data;
    private boolean isPago;
    @ManyToOne
    @JoinColumn(name = "aluno_matricula", referencedColumnName = "matricula")
    private Aluno aluno;

    // Construtores, getters e setters

}