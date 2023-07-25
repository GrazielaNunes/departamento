package com.exercicio.departamento.services;

import com.exercicio.departamento.model.Departamento;
import com.exercicio.departamento.model.Funcionario;
import com.exercicio.departamento.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    public Funcionario salvar(Funcionario pessoa){
        return funcionarioRepository.save(pessoa);
    }

    public List<Funcionario> listarTodos() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return funcionarios;
    }

    public void deletar(Long id) {
        funcionarioRepository.deleteById(id);
    }

}
