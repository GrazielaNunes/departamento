package com.exercicio.departamento.repository;


import com.exercicio.departamento.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {


    Departamento findByNome(String nome);
}

