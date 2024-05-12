package com.laranjeirosgroup.ac2.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Agendas")
public class Agenda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonIgnoreProperties({"agenda", "curso"})
    private Professor professor;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonIgnoreProperties({"agenda", "professor"})
    private Curso curso;

    private LocalDateTime data;
    private LocalDateTime horario;
    private String cidade;
    private String uf;
    private String cep;

}
