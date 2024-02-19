package com.biblioteca.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.biblioteca.dao.AutorDAO;
import com.biblioteca.model.Autor;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AutorRepository implements AutorDAO {
    @Autowired
    private EntityManager entityManager;
    @Override
    public Autor findById(Long id) {
        return entityManager.find(Autor.class, id);
    }

    @Override
    public List<Autor> findAll() {
        return entityManager.createQuery("SELECT a FROM autor a", Autor.class).getResultList();
    }

    @Transactional
    @Override
    public Autor save(Autor autor) {
        entityManager.persist(autor);
        return autor;
    }
}