package com.biblioteca.model;

import java.util.Date;
import jakarta.persistence.*;

@Entity
public class ItemEmprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dataPrevista;

    @ManyToOne
    @JoinColumn(name = "livro_id", referencedColumnName = "id")
    private Livro livro;

    @ManyToOne
    @JoinColumn(name = "emprestimo_id", referencedColumnName = "id")
    private Emprestimo emprestimo;

    // Construtores, getters e setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getDataPrevista() {
        return dataPrevista;
    }
    public void setDataPrevista(Date dataPrevista) {
        this.dataPrevista = dataPrevista;
    }
    public Livro getLivro() {
        return livro;
    }
    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    public Emprestimo getEmprestimo() {
        return emprestimo;
    }
    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

}
