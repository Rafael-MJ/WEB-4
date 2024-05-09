package com.laranjeirosgroup.ac2.Dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AgendaDTO(
        LocalDate data,
        LocalDateTime horario,
        String cidade,
        String uf,
        String cep) {
}
