package com.biblioteca.repository;


import com.biblioteca.model.Emprestimo;
import com.biblioteca.dao.EmprestimoDAO;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmprestimoRepository implements EmprestimoDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public Emprestimo findById(Long id) {
        return null;
    }

    @Override
    public Emprestimo findByAlunoMatricula(String matricula) {
        return null;
    }

    @Override
    public List<Emprestimo> findAll() {
        return entityManager.createQuery("SELECT a FROM emprestimos a", Emprestimo.class).getResultList();
    }

    @Transactional
    @Override
    public Emprestimo save(Emprestimo emprestimo) {
        entityManager.persist(emprestimo);
        return emprestimo;
    }
}