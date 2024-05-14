package com.laranjeirosgroup.ac2.Repositories;

import com.laranjeirosgroup.ac2.Models.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer> {
  List<Agenda> findByProfessorId(int professorId);

  @Query("SELECT a.dataHora FROM Agenda a WHERE a.professor.id = :professorId")
  List<LocalDateTime> findHorariosByProfessorId(int professorId);
}
