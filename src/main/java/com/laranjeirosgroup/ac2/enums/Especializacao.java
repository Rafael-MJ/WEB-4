package com.laranjeirosgroup.ac2.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Especializacao {
  ACUPUNTURA("Acupuntura"),
  AQUATICA("Aquática"),
  CARDIOVASCULAR("Cardiovascular"),
  ESPORTIVA("Esportiva");

  private final String especializacao;
}
