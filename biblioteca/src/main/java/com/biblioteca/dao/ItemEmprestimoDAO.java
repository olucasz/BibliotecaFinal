package com.biblioteca.dao;

import com.biblioteca.model.ItemEmprestimo;

import java.util.List;

public interface ItemEmprestimoDAO {
    ItemEmprestimo findById(Long id);
    ItemEmprestimo findByEmprestimo(Long emprestimoId);
    boolean findByLivro(Long livroId);
    List<ItemEmprestimo> findAll();
    ItemEmprestimo save(ItemEmprestimo itemEmprestimo);
}