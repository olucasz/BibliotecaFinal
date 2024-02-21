package com.biblioteca.controller;

import java.util.ArrayList;
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

import com.biblioteca.model.Debito;
import com.biblioteca.model.Devolucao;
import com.biblioteca.model.Emprestimo;
import com.biblioteca.model.ItemDevolucao;
import com.biblioteca.model.ItemEmprestimo;
import com.biblioteca.repository.DebitoRepository;
import com.biblioteca.repository.DevolucaoRepository;
import com.biblioteca.repository.EmprestimoRepository;
import com.biblioteca.repository.ItemEmprestimoRepository;


@RestController
@RequestMapping("/devolucao")
public class DevolucaoController {
    @Autowired
    private DevolucaoRepository devolucaorepository;

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private ItemEmprestimoRepository itemEmprestimoRepository;

    @Autowired
    private AlunoController alunoController;

    @Autowired
    private DebitoRepository debitoRepository;

    @Autowired
    private ItemDevolucaoRepository itemDevolucaoRepository;

    //Requisições http
    @PostMapping
    public ResponseEntity<Devolucao> cadastrarDevolucao(@RequestBody Devolucao devolucao) {
        return ResponseEntity.ok(devolucaorepository.save(devolucao));
    }
  
    @GetMapping("/{id}")
    public ResponseEntity<Devolucao> buscarPorId(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(devolucaorepository.findById(id));
    }
  
    @GetMapping("aluno/{matricula}")
    public ResponseEntity<Devolucao> buscarPorMatricula(@PathVariable(value = "matricula") int matricula) {
        return ResponseEntity.ok(devolucaorepository.findByMatricula(matricula));
    }

    @GetMapping
    public ResponseEntity<List<Devolucao>> findAll() {
        return ResponseEntity.ok(devolucaorepository.findAll());
    }

    // Metodos de negocio
    public boolean devolverLivro(String matricula, List<Long> idLivro) throws BadRequestException {
        Date dataAtual = new Date();

        // Verifica se o aluno está cadastrado
        if (alunoController.findByMatricula(matricula) == null) {
            throw new BadRequestException("Aluno não encontrado");
        }

        // Verifica se o aluno possui emprestimos pendentes
        if (emprestimoRepository.findByMatricula(matricula) == null) {
            throw new BadRequestException("Aluno não possui emprestimos pendentes");
        }
        
        // Seleciona os emprestimos pendentes
        List<Emprestimo> emprestimos = emprestimoRepository.findByMatricula(matricula);

        // cria uma devolucao
        Devolucao devolucao = new Devolucao();

        Long idEmprestimoaux = 0L;

        // Verifica de qual emprestimo pertence o livro
        for (Emprestimo emprestimo : emprestimos) {
            // Acha os itens do emprestimo que pertecem a esse emprestimo
            List<ItemEmprestimo> itens = itemEmprestimoRepository.findByEmprestimosId(emprestimo.getIdEmprestimo());
            for (ItemEmprestimo item : itens) {
                if (idLivro.contains(item.getLivro().getId())) {
                    idEmprestimoaux = emprestimo.getId();
                    break;
                }
            }
        }
        List<ItemEmprestimo> itens = itemEmprestimoRepository.findById(idEmprestimoaux);

        
        double multa = emprestimoRepository.findById(idEmprestimoaux).getMulta();
        int diasAtraso = 0;
        double valor = 0;
        // Verificar se teve atraso
        if (dataAtual.after(emprestimoRepository.findById(idEmprestimoaux).getDataPrevista())) {
            devolucao.setAtraso(true);
            diasAtraso = (int) ((dataAtual.getTime() - emprestimoRepository.findById(idEmprestimoaux).getDataPrevista().getTime()) / (1000 * 60 * 60 * 24));
            valor = calcularMulta(multa, diasAtraso);
        } else {
            devolucao.setAtraso(false);
        }

        List<ItemDevolucao> itensDevolucao = new ArrayList<ItemDevolucao>();
        for(ItemEmprestimo item : itens){
            if (idLivro.contains(item.getLivro().getIdLivro())) {
                ItemDevolucao itemDevolucao = new ItemDevolucao();
                itemDevolucao.setDataDevolucao(dataAtual);
                itemDevolucao.setMulta(multa);
                itemDevolucao.setDiasAtraso(diasAtraso);
                itemDevolucao.setValor(valor);
                itemDevolucao.setLivro(item.getLivro());
                itensDevolucao.add(itemDevolucao);
                //Exclui o idLivro da lista
                idLivro.remove(item.getLivro().getIdLivro());
            }
        }
    
        //teste

       

        devolucao.setValorTotal(valorTotal);
        devolucao.setDataDevolucao(dataAtual);
    
        devolucaorepository.save(devolucao);

        //Verifica atraso
        if(devolucao.isAtraso()){
            //Cria um debito
            Debito debito = new Debito();
            Integer multaInt = (int) valorTotal;
            debito.setValor(multaInt);
            debito.setData(dataAtual);
            debito.setAluno(alunoController.findByMatricula(matricula).getBody());
            //Cadastra o debito
            debitoRepository.save(debito);
        }

       //cria itens devolucao
        for (ItemDevolucao itemDevolucao : itensDevolucao) {
            itemDevolucao.setDevolucao(devolucao);
            itemDevolucaoRepository.save(itemDevolucao);
        }
        return true;
    }

    public double calcularMulta(double multa, int diasAtraso){
        return diasAtraso * multa;
    }
}