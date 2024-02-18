package com.biblioteca.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.biblioteca.dao.AlunoDAO;
import com.biblioteca.model.Aluno;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AlunoRepository implements AlunoDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Aluno findByMatricula(String matricula) {
            return entityManager.createQuery("SELECT a FROM alunos a WHERE a.matricula = :matricula", Aluno.class)
                    .setParameter("matricula", matricula)
                    .getSingleResult();

    }
    @Override
    public List<Aluno> findAll() {
        return entityManager.createQuery("SELECT a FROM alunos a", Aluno.class).getResultList();
    }
    
    @Transactional
    @Override
    public Aluno save(Aluno aluno) {
        entityManager.persist(aluno);
        return aluno;
    }

}
