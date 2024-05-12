package com.laranjeirosgroup.ac2.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CursoDTO(
    @NotBlank String nome,
    @NotBlank String descricao,
    @NotNull double cargaHoraria,
    @NotBlank String objetivo,
    @NotBlank String ementa,
    int professor) {
}
