package com.biblioteca.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.biblioteca.dao.TituloDAO;
import com.biblioteca.model.Titulo;


import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class TituloRepository implements TituloDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public Titulo findByIsbn(String isbn) {
        return entityManager.createQuery("SELECT a FROM titulo a WHERE a.isbn = :isbn", Titulo.class)
            .setParameter("isbn", isbn).getSingleResult();
    }

    @Override
    public List<Titulo> findAll() {
        return entityManager.createQuery("SELECT a FROM titulo a", Titulo.class).getResultList();
    }

    @Transactional
    @Override
    public Titulo save(Titulo titulo) {
        entityManager.persist(titulo);
        return titulo;
    }
}
