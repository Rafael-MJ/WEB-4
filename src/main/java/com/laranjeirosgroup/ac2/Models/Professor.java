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

    @Override
    public String toString() {
        return "Professor [id=" + id + ", nome=" + nome + ", cpf=" + cpf
          + ", rg=" + rg + ", endereco=" + endereco + ", celular=" + celular + "]";
    }
    
}
