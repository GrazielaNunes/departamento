package com.exercicio.departamento.controllers;

import com.exercicio.departamento.model.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.exercicio.departamento.services.DepartamentoService;

import java.util.List;

@RestController
@RequestMapping(value = "/departamento") // localhost:8091/departamentos
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @PostMapping
    public ResponseEntity<Departamento> salvar(@RequestBody Departamento departamento) {
        Departamento d = departamentoService.salvar(departamento);
        return new ResponseEntity<>(d, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Departamento>> listarTodos() {
        List<Departamento> departamentos = departamentoService.listarTodos();
        return new ResponseEntity<>(departamentos, HttpStatus.FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable Long id) {
        departamentoService.deletar(id);
        return new ResponseEntity<>("O departamento de id: " + id + " foi deletado com sucesso!", HttpStatus.OK);

    }

    @GetMapping(value = "/bynome/{nome}")
    public ResponseEntity<Departamento> buscarPorNome(@PathVariable String nome) {
        Departamento d = departamentoService.buscarPorNome(nome);
        return new ResponseEntity<>(d, HttpStatus.OK);

    }
}