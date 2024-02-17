package com.biblioteca.model;

import java.util.List;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Devolucao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dataDevolucao;
    private boolean atraso;
    private float valorTotal;
    private float multa;
    @OneToMany
    private List<ItemDevolucao> itensDevolucao;

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
    public boolean isAtraso() {
        return atraso;
    }
    public void setAtraso(boolean atraso) {
        this.atraso = atraso;
    }
    public float getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    public float getMulta() {
        return multa;
    }
    public void setMulta(float multa) {
        this.multa = multa;
    }
    public List<ItemDevolucao> getItensDevolucao() {
        return itensDevolucao;
    }
    public void setItensDevolucao(List<ItemDevolucao> itensDevolucao) {
        this.itensDevolucao = itensDevolucao;
    }

}
