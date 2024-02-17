package com.biblioteca.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Debito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int valor;
    private Date data;
    @ManyToOne
    @JoinColumn(name = "aluno_matricula", referencedColumnName = "matricula")
    private Aluno aluno;

    // Construtores, getters e setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }

}