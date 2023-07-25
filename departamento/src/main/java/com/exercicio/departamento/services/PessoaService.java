package com.exercicio.departamento.services;

import com.exercicio.departamento.model.Funcionario;
import com.exercicio.departamento.model.Pessoa;
import com.exercicio.departamento.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;
    public List<Pessoa> listarTodos() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        return pessoas;
    }

    public void deletar(Long id) {
        pessoaRepository.deleteById(id);
    }

    public Pessoa salvar(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public Pessoa buscarPorNome(String nome) {
        Pessoa p = pessoaRepository.findByNome(nome);
        return p;
    }
}

