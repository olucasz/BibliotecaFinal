package com.biblioteca.dao;

import com.biblioteca.model.Livro;
import java.util.List;

public interface LivroDAO {
    Livro findById(String id);
    List<Livro> findAll();
    Livro save(Livro livro);
}



