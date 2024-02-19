package com.biblioteca.repository;


import com.biblioteca.dao.LivroDAO;
import com.biblioteca.model.Livro;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class LivroRepository implements LivroDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Livro findById(Long id) {
        return entityManager.find(Livro.class, id);
    }

    @Override
    public List<Livro> findAll() {
        return entityManager.createQuery("SELECT a FROM livro a", Livro.class).getResultList();
    }

    @Override
    public Livro findByIsbn(String isbn) {
        return entityManager.createQuery("SELECT a FROM livro a WHERE a.titulo.isbn = :isbn", Livro.class)
            .setParameter("isbn", isbn).getSingleResult();
    }

    @Transactional
    @Override
    public Livro save(Livro livro) {
        entityManager.persist(livro);
        return livro;
    }
}
