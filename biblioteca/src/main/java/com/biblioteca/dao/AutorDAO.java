package com.biblioteca.dao;

import java.util.List;

import com.biblioteca.model.Autor;

public interface AutorDAO {
    Autor save(Autor autor);
    Autor findById(Long id);
    List<Autor> findAll();
}
