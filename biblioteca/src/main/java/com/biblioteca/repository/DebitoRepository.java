package com.biblioteca.repository;

import com.biblioteca.dao.DebitoDAO;
import com.biblioteca.model.Debito;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DebitoRepository implements DebitoDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Debito> listarDebitosAluno(String matricula) {
        return entityManager.createQuery("SELECT d FROM debitos d WHERE d.aluno.matricula = :matricula", Debito.class)
                .setParameter("matricula", matricula)
                .getResultList();
    }

    @Transactional
    @Override
    public Debito adicionarDebito(Debito debito) {
        entityManager.persist(debito);
        return debito;
    }
}