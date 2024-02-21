package com.biblioteca.dao;

import java.util.List;

import com.biblioteca.model.ItemDevolucao;

public interface ItemDevolucaoDAO {
    public ItemDevolucao save(ItemDevolucao itemDevolucao);
    public ItemDevolucao findById(Long id);
    public ItemDevolucao findByLivroId(Long id);
    public List<ItemDevolucao> findAll();
}