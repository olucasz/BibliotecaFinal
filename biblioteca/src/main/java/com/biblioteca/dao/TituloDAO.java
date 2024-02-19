package com.biblioteca.dao;

import java.util.List;

import com.biblioteca.model.Titulo;

public interface TituloDAO {
    Titulo save(Titulo titulo);
    Titulo findByIsbn(String isbn);
    List<Titulo> findAll();
}