package com.laranjeirosgroup.ac2.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Cursos")
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String descricao;
    private double cargaHoraria;
    private String objetivo;
    private String ementa;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn
    @JsonIgnoreProperties({"agenda", "curso"})
    private Professor professor;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn
    @JsonIgnoreProperties({"curso", "professor"})
    private Agenda agenda;
}
