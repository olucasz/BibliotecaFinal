package com.biblioteca.dao;

import com.biblioteca.model.Aluno;
import java.util.List;

public interface AlunoDAO {

    Aluno findByMatricula(String matricula);
    List<Aluno> findAll();
    Aluno save(Aluno aluno);
    
}