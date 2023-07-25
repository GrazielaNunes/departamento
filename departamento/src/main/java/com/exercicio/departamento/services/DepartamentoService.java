package com.exercicio.departamento.services;

import com.exercicio.departamento.model.Departamento;
import com.exercicio.departamento.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    @Autowired
    DepartamentoRepository departamentoRepository;

    public Departamento salvar(Departamento departamento){
        return departamentoRepository.save(departamento);
    }

    public List<Departamento> listarTodos() {
        List<Departamento> departamentos = departamentoRepository.findAll();
        return departamentos;
    }
    public void deletar(Long id) {
        departamentoRepository.deleteById(id);
    }


    public Departamento buscarPorNome(String nome) {
        Departamento d = departamentoRepository.findByNome(nome);
        return d;
    }
}
