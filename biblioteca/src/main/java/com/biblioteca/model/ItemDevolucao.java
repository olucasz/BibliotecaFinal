package com.biblioteca.model;

import jakarta.persistence.*;
import java.util.Date;

public class ItemDevolucao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dataDevolucao;
    private int diasAtraso;
    private float valor;
    private float multa;
    @ManyToOne
    @JoinColumn(name = "livro_id", referencedColumnName = "id")
    private Livro livro;
    @ManyToOne
    @JoinColumn(name = "devolucao_id", referencedColumnName = "id")
    private Devolucao devolucao;

    // Construtores, getters e setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getDataDevolucao() {
        return dataDevolucao;
    }
    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    public int getDiasAtraso() {
        return diasAtraso;
    }
    public void setDiasAtraso(int diasAtraso) {
        this.diasAtraso = diasAtraso;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public float getMulta() {
        return multa;
    }
    public void setMulta(float multa) {
        this.multa = multa;
    }
    public Livro getLivro() {
        return livro;
    }
    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    public Devolucao getDevolucao() {
        return devolucao;
    }
    public void setDevolucao(Devolucao devolucao) {
        this.devolucao = devolucao;
    }
    
}
