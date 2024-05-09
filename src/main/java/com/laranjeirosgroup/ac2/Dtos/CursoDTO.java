package com.laranjeirosgroup.ac2.Dtos;

import jakarta.validation.constraints.NotBlank;

public record CursoDTO(
    @NotBlank String descricao,
    @NotBlank String cargaHoraria,
    @NotBlank String objetivo,
    @NotBlank String ementa ) {
}
