package com.laranjeirosgroup.ac2.Repositories;

import com.laranjeirosgroup.ac2.Models.Professor;
import com.laranjeirosgroup.ac2.enums.Especializacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
    List<Professor> findByEspecializacao(Especializacao especializacao);

    @Query("SELECT COUNT(a) FROM Agenda a WHERE a.professor.id = :professorId AND a.dataHora = :dataHora")
    int countAgendasByProfessorAndDate(int professorId, LocalDateTime dataHora);
}
