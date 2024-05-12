package com.laranjeirosgroup.ac2.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.engine.internal.Cascade;

import java.io.Serializable;
import java.util.List;

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

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn
    @JsonIgnoreProperties({"agenda", "professor"})
    private Curso curso;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn
    @JsonIgnoreProperties({"curso", "professor"})
    private Agenda agenda;
}
