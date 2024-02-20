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
    public List<Debito> findByDebitos(String matricula) {
        return entityManager.createQuery("SELECT d FROM debito d WHERE d.aluno.matricula = :matricula", Debito.class)
                .setParameter("matricula", matricula)
                .getResultList();
    }

    @Override
    public Debito findById(Long id) {
        return entityManager.find(Debito.class, id);
    }

    @Override
    public List<Debito> findAll() {
        return entityManager.createQuery("SELECT d FROM debito d", Debito.class).getResultList();
    }


    @Transactional
    @Override
    public Debito save(Debito debito) {
        entityManager.persist(debito);
        return debito;
    }

    public boolean verificarDebito(String matricula) {
        if (findByDebitos(matricula).size() > 0){
            return true;
        }
        return false;
    }
}