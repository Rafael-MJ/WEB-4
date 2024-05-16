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

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(nullable = false)
    @JsonIgnoreProperties({"agenda", "curso"})
    private Professor professor;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(nullable = false)
    @JsonIgnoreProperties({"agenda", "professor"})
    private Curso curso;

    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private String cidade;
    private String uf;
    private String cep;
    private String resumoTreinamento;
}
