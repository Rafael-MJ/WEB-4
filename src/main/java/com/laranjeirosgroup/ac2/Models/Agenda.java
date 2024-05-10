package com.laranjeirosgroup.ac2.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Agendas")
public class Agenda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn
    private Professor professor;

    @ManyToOne
    @JoinColumn
    private Curso curso;

    private LocalDateTime data;
    private LocalDateTime horario;
    private String cidade;
    private String uf;
    private String cep;

    @Override
    public String toString() {
        return "Agenda [id=" + id + ", professor=" + professor + ", curso="
          + curso + ", data=" + data + ", horario=" + horario + ", cidade="
          + cidade + ", uf=" + uf + ", cep=" + cep + "]";
    }

}
