package com.laranjeirosgroup.ac2.Repositories;

import com.laranjeirosgroup.ac2.Models.Agenda;
import com.laranjeirosgroup.ac2.Models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer> {
  List<Agenda> findByProfessorId(int professorId);

  @Query("SELECT DISTINCT p FROM Professor p WHERE p.id NOT IN " +
    "(SELECT DISTINCT a.professor.id FROM Agenda a WHERE " +
    "((a.dataHoraInicio BETWEEN :inicio AND :fim) OR " +
    "(a.dataHoraFim BETWEEN :inicio AND :fim)))")
  List<Professor> findProfessoresDisponiveis(@Param("inicio") LocalDateTime inicio,
                                             @Param("fim") LocalDateTime fim);
}
