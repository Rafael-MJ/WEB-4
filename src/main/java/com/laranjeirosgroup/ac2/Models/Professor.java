package com.laranjeirosgroup.ac2.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.laranjeirosgroup.ac2.enums.Especializacao;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Professores")
public class Professor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String cpf;
    private String rg;
    private String endereco;
    private String celular;
    private Especializacao especializacao;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn
    @JsonIgnoreProperties({"agenda", "professor"})
    private Curso curso;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn
    @JsonIgnoreProperties({"curso", "professor"})
    private Agenda agenda;
}
