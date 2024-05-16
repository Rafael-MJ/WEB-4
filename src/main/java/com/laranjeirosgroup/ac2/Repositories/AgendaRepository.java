package com.laranjeirosgroup.ac2.Repositories;

import com.laranjeirosgroup.ac2.Models.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer> {
  List<Agenda> findByProfessorId(int professorId);

  @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END " +
          "FROM Agenda a WHERE a.professor.id = :professorId " +
          "AND ((a.dataHoraInicio BETWEEN :inicio AND :fim) " +
          "OR (a.dataHoraFim BETWEEN :inicio AND :fim))")
  boolean isAgendaLotada(@Param("professorId") int professorId,
    @Param("inicio") LocalDateTime inicio, @Param("fim") LocalDateTime fim);
}
