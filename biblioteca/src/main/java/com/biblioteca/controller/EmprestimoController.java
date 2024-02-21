package com.biblioteca.controller;


// import java.util.ArrayList;
import java.util.Date;
// import java.util.ArrayList;
// import java.util.Date;
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

// import com.biblioteca.model.Debito;
import com.biblioteca.model.Emprestimo;
import com.biblioteca.model.ItemEmprestimo;
// import com.biblioteca.model.Livro;
import com.biblioteca.repository.EmprestimoRepository;


@RestController
@RequestMapping("/emprestimo")

public class EmprestimoController{

    @Autowired
    private EmprestimoRepository emprestimoRepository;
    
    @Autowired
    private LivroController livroController;

    @Autowired
    private ItemEmprestimoController itemEmprestimoController;

    @Autowired
    private AlunoController alunoController;

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

        // // Teste
        // List<Long> idLivro = new ArrayList<Long>();
        // idLivro.add(1L);
             
        // try {
        //     realizarEmprestimo("123", idLivro);
        // } catch (BadRequestException e) {
        //     e.printStackTrace();
        // }

        return ResponseEntity.ok(emprestimoRepository.findAll());
    }

    //Métodos de negócio
    public void realizarEmprestimo(String matricula, List<Long> idLivros) throws BadRequestException {
        Date dataEmprestimo = new Date();
        // Date dataPrevista = new Date();
        //verifica matricula do aluno
        if (alunoController.findByMatricula(matricula) == null) {
            throw new BadRequestException("Aluno não encontrado");
        }
        //verifica se o aluno possui débitos
        if (alunoController.verificarDebito(matricula)) {
            throw new BadRequestException("Aluno possui débitos");
        }
        //verifica se os livros estão disponíveis
        for (Long id : idLivros) {
            if (livroController.verificaLivro(id) == false) {
                throw new BadRequestException("Livro não encontrado");
            }
        }
        
        //cria emprestimo
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setDataEmprestimo(dataEmprestimo);
        emprestimo.setDataPrevista(new Date());
        emprestimo.setDevolucao(null);
        emprestimo.setAluno(alunoController.findByMatricula(matricula).getBody());

        //para cada livro
        for (Long id : idLivros) {
            //cria item emprestimo
            ItemEmprestimo itemEmprestimo = new ItemEmprestimo();
            itemEmprestimo.setLivro(livroController.findById(id).getBody());
            itemEmprestimo.setEmprestimo(emprestimo);
            itemEmprestimoController.criarItemEmprestimo(itemEmprestimo);
        }
    } 
}


