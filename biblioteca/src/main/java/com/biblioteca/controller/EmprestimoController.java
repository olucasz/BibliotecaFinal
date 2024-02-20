package com.biblioteca.controller;


// import java.util.ArrayList;
// import java.util.Date;
import java.util.List;

// import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.model.Emprestimo;
// import com.biblioteca.model.ItemEmprestimo;
// import com.biblioteca.model.Livro;
import com.biblioteca.repository.EmprestimoRepository;


@RestController
@RequestMapping("/emprestimo")

public class EmprestimoController{

    @Autowired
    private EmprestimoRepository emprestimoRepository;
    
    // @Autowired
    // private LivroController livroController;

    // @Autowired
    // private ItemEmprestimoController itemEmprestimoController;

    // @Autowired
    // private AlunoController alunoController;

    @PostMapping
    public ResponseEntity<Emprestimo> criarEmprestimo(@RequestBody Emprestimo emprestimo){
        return ResponseEntity.ok(emprestimoRepository.save(emprestimo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprestimo> findById(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(emprestimoRepository.findById(id));
    }

    @GetMapping("/matricula/{matricula}")
    public ResponseEntity<Emprestimo> findByMatricula(@PathVariable(value = "matricula") String matricula){
        return ResponseEntity.ok(emprestimoRepository.findByMatricula(matricula));
    }

    @GetMapping
    public ResponseEntity<List<Emprestimo>> findAll(){
        return ResponseEntity.ok(emprestimoRepository.findAll());
    }

    //criar função para emprestar livro 
    //data de emprestimo
    //data de devolução
    //verificar se o aluno esta matriculado
    //verificar se o aluno tem debito
    //verificar se o livro esta disponivel
    //criar um emprestimo
   
    // public Emprestimo emprestarLivro(String matricula, Long id) throws BadRequestException{
    //     //verifica se o aluno está matriculado
    //     if (alunoController.findByMatricula(matricula) == null) {
    //         throw new BadRequestException("Aluno não matriculado");
    //     }
    //     //verifica se o aluno tem debito
    //     if (alunoController.verificaDebito(matricula)) {
    //         throw new BadRequestException("Aluno com debito");
    //     }
    //     //verifica se o livro está disponivel
    //     if (!livroController.verificaLivro(id)) {
    //         throw new BadRequestException("Livro não disponivel");
    //     }
    //     //criar um emprestimo
    //     Emprestimo emprestimo = new Emprestimo();
    //     emprestimo.setMatricula(matricula);
    //     emprestimo.setDataEmprestimo(new Date());
    //     emprestimo.setDataDevolucao(new Date());
    //     emprestimoRepository.save(emprestimo);
    //     //criar um item emprestimo
    //     ItemEmprestimo itemEmprestimo = new ItemEmprestimo();
    //     itemEmprestimo.setEmprestimo(emprestimo);
    //     itemEmprestimo.setLivro(livroController.findById(id));
    //     itemEmprestimoController.criarItemEmprestimo(itemEmprestimo);
    //     return emprestimo;
    // }

}


