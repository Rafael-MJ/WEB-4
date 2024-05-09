package com.laranjeirosgroup.ac2.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Cursos")
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String descricao;
    private String cargaHoraria;
    private String objetivo;
    private String ementa;

    //Todo: Professor
    //Todo: Agenda

    @Override
    public String toString() {
        return "Curso [id=" + id + ", descricao=" + descricao + ", carga_horaria="
          + cargaHoraria + ", objetivo=" + objetivo + ", ementa=" + ementa + "]";
    }

}
