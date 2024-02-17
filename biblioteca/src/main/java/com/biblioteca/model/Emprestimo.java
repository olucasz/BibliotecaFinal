package com.biblioteca.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataEmprestimo;
    private Date dataPrevista;
    private float multa;
    @OneToOne
    private Devolucao devolucao;
    @ManyToOne
    private Aluno aluno;
    // Outros atributos e métodos getters/setters

    // Getters e Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }
    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
    public Date getDataPrevista() {
        return dataPrevista;
    }
    public void setDataPrevista(Date dataPrevista) {
        this.dataPrevista = dataPrevista;
    }
    public float getMulta() {
        return multa;
    }
    public void setMulta(float multa) {
        this.multa = multa;
    }
    public Devolucao getDevolucao() {
        return devolucao;
    }
    public void setDevolucao(Devolucao devolucao) {
        this.devolucao = devolucao;
    }
    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    

}