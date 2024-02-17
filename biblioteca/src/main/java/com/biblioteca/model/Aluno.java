package com.biblioteca.model;

import jakarta.persistence.*;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int matricula;
    private String nome;
    private String cpf;
    private String endereço;
    
    //funções que vão ser implementadas - verificarDebito, realizarEmprestimo

    // Getters e Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEndereço() {
        return endereço;
    }
    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

}
