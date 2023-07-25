package com.exercicio.departamento.controllers;

import com.exercicio.departamento.model.Funcionario;
import com.exercicio.departamento.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/funcionario") // localhost:8091/funcionarios
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario) {
        Funcionario f = funcionarioService.salvar(funcionario);
        return new ResponseEntity<>(f, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> listarTodos() {
        List<Funcionario> funcionarios = funcionarioService.listarTodos();
        return new ResponseEntity<>(funcionarios, HttpStatus.FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable Long id) {
        funcionarioService.deletar(id);
        return new ResponseEntity<>("O funcionario de id: " + id + " foi deletado com sucesso!", HttpStatus.OK);

    }
}
