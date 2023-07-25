package com.exercicio.departamento.controllers;

import com.exercicio.departamento.model.Funcionario;
import com.exercicio.departamento.model.Pessoa;
import com.exercicio.departamento.services.FuncionarioService;
import com.exercicio.departamento.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoa") // localhost:8091/pessoas
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> salvar(@RequestBody Pessoa pessoa) {
        Pessoa p = pessoaService.salvar(pessoa);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarTodos() {
        List<Pessoa> pessoas = pessoaService.listarTodos();
        return new ResponseEntity<>(pessoas, HttpStatus.FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable Long id) {
        pessoaService.deletar(id);
        return new ResponseEntity<>("A pessoa de id: " + id + " foi deletada com sucesso!", HttpStatus.OK);

    }

    @GetMapping(value = "/bynome/{nome}")
    public ResponseEntity<Pessoa> buscarPorNome(@PathVariable String nome) {
        Pessoa p = pessoaService.buscarPorNome(nome);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
}
