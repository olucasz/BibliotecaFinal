package com.biblioteca.model;

import java.util.List;
import java.util.Date;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "devolucao")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

}
