package com.laranjeirosgroup.ac2.Dtos;

import jakarta.validation.constraints.NotBlank;

public record ProfessorDTO(
    @NotBlank String nome,
    @NotBlank String cpf,
    @NotBlank String rg,
    @NotBlank String endereco,
    @NotBlank String celular,
    int curso) {
}
