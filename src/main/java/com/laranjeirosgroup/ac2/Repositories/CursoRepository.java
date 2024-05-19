package com.laranjeirosgroup.ac2.Repositories;

import com.laranjeirosgroup.ac2.Models.Curso;
import com.laranjeirosgroup.ac2.Models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

    @Query("SELECT p FROM Professor p WHERE p.especializacao = (SELECT c.especializacaoNecessaria FROM Curso c WHERE c.id = :cursoId)")
    List<Professor> findProfessorEspecilizacaoCurso(@Param("cursoId") int cursoId);

}
