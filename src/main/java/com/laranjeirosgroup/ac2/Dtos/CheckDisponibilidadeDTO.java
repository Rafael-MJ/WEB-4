package com.laranjeirosgroup.ac2.Dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CheckDisponibilidadeDTO(
  @NotNull LocalDateTime dataHoraInicio,
  @NotNull LocalDateTime dataHoraFim
  ) {
}
