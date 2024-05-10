package com.laranjeirosgroup.ac2.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AgendaDTO(
    @NotNull LocalDateTime data,
    @NotNull LocalDateTime horario,
    @NotBlank String cidade,
    @NotBlank String uf,
    @NotBlank String cep ) {
}
