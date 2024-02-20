package com.biblioteca.controller;

import java.util.Date;
import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.model.Livro;
import com.biblioteca.model.Titulo;
import com.biblioteca.repository.LivroRepository;
import com.biblioteca.repository.TituloRepository;


@RestController
@RequestMapping("/livro")
public class LivroController {

    //Requisições http
    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private TituloRepository tituloRepository;

    @PostMapping
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody Livro livro) {
        return ResponseEntity.ok(livroRepository.save(livro));
    }

    @GetMapping
    public ResponseEntity<List<Livro>> findAll() {
        return ResponseEntity.ok(livroRepository.findAll());
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Livro> findByIsbn(@PathVariable(value = "isbn")String isbn) {
        return ResponseEntity.ok(livroRepository.findByIsbn(isbn));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Livro> findById(@PathVariable(value = "id")Long id) {
        return ResponseEntity.ok(livroRepository.findById(id));
    }


    //função para verificar livro
    public Boolean verificaLivro(Long id) throws BadRequestException{
        //Verifica se o livro já está cadastrado
        if (livroRepository.findById(id) == null) {
            return false;
        }
        Livro livro = livroRepository.findById(id);
        //Verifica se o livro está disponivel
        if(livro.isDisponivel() == false){
            throw new BadRequestException("Livro não está disponível para empréstimo");
        }
        //Verifica se é exemplar
        if(livro.isExemplarBiblioteca() == false){
            return false;
        }
    
        return true;

    }

    //set livro
    
    
    public Integer verPrazo(String isbn){
        Titulo titulo = tituloRepository.findByIsbn(isbn);
        return titulo.getPrazo();
        
    }

}