package com.laranjeirosgroup.ac2.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AgendaDTO(
    @NotNull LocalDateTime dataHoraInicio,
    @NotNull LocalDateTime dataHoraFim,
    @NotBlank String cidade,
    @NotBlank String uf,
    @NotBlank String cep,
    @NotNull int curso,
    @NotNull int professor) {
}
