package com.exercicio.departamento.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_departamento", foreignKey = @ForeignKey(name = "fk_departamento"))
    private Departamento departamento;

    @Column
    private Double salario;

    @Column
    private Date dataContrato;

    @Column
    private Date dataCadastro;

    @Column
    private Boolean estado;

    @OneToOne
    @JoinColumn(name = "id_pessoa", foreignKey = @ForeignKey(name = "fk_pessoa"))
    private Pessoa pessoa;

}
