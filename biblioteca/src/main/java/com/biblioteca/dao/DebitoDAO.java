package com.biblioteca.dao;

import com.biblioteca.model.Debito;

import java.util.List;

public interface DebitoDAO {
    List<Debito> listarDebitosAluno(String matricula);
    Debito adicionarDebito(Debito debito);
}