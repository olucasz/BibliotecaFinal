package com.biblioteca.model;

import java.util.Date;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity(name = "item_emprestimo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
}
