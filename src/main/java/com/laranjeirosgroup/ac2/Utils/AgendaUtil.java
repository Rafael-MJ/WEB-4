package com.laranjeirosgroup.ac2.Utils;

import java.time.LocalDateTime;
import java.util.List;

public class AgendaUtil {

  public static boolean verificarDisponibilidade(List<LocalDateTime> dateTimeList, LocalDateTime targetDateTime) {
    for (LocalDateTime dateTime : dateTimeList) {
      if (dateTime.isEqual(targetDateTime) ||
        (dateTime.isAfter(targetDateTime) && dateTime.isBefore(targetDateTime.plusHours(1))) ||
        (dateTime.plusHours(1).isAfter(targetDateTime) && dateTime.plusHours(1).isBefore(targetDateTime.plusHours(2)))) {
        return true;
      }
    }

    return false;
  }

}