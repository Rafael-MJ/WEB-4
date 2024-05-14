package com.laranjeirosgroup.ac2.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.laranjeirosgroup.ac2.enums.Especializacao;

public record ProfessorDTO(
    @NotBlank String nome,
    @NotBlank String cpf,
    @NotBlank String rg,
    @NotBlank String endereco,
    @NotBlank String celular,
    @NotNull Especializacao especializacao,
    int curso) {
}
