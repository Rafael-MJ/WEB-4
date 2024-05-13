package com.laranjeirosgroup.ac2.Repositories;

import com.laranjeirosgroup.ac2.Models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
    List<Professor> findByEspecializacao(String especializacao);

    @Query("SELECT COUNT(a) FROM Agenda a WHERE a.professor.id = :professorId AND a.data = :data")
    int countAgendasByProfessorAndDate(Long professorId, LocalDateTime data);
}
