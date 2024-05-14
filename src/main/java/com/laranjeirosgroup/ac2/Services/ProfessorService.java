package com.laranjeirosgroup.ac2.Services;

import com.laranjeirosgroup.ac2.Dtos.ProfessorDTO;
import com.laranjeirosgroup.ac2.Models.Curso;
import com.laranjeirosgroup.ac2.Models.Professor;
import com.laranjeirosgroup.ac2.Repositories.AgendaRepository;
import com.laranjeirosgroup.ac2.Repositories.CursoRepository;
import com.laranjeirosgroup.ac2.Repositories.ProfessorRepository;
import com.laranjeirosgroup.ac2.enums.Especializacao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

  @Autowired()
  private ProfessorRepository professorRepository;

  @Autowired()
  private CursoRepository cursoRepository;

  @Autowired
  private AgendaRepository agendaRepository;

  public List<Professor> buscarProfessoresPorEspecializacao(Especializacao especializacao) {
    return professorRepository.findByEspecializacao(especializacao);
  }

  public boolean verificarDisponibilidadeProfessor(int professorId, LocalDateTime data) {
    int count = professorRepository.countAgendasByProfessorAndDate(professorId, data);
    return count == 0;
  }

  @Transactional()
  public Professor registerProfessor(ProfessorDTO professorDTO, int cursoId) {
    var newProfessor = new Professor();
    BeanUtils.copyProperties(professorDTO, newProfessor);

    Optional<Curso> optionalCurso = cursoRepository.findById(cursoId);
    if (optionalCurso.isPresent()) {
      Curso curso = optionalCurso.get();
      newProfessor.setCurso(curso);
      curso.setProfessor(newProfessor);
      cursoRepository.save(curso);
    }

    return professorRepository.save(newProfessor);
  }

  public List<Professor> getAllProfessores() {
    return professorRepository.findAll();
  }

  public Optional<Professor> getProfessorById(int professorId) {
    return professorRepository.findById(professorId);
  }

  @Transactional()
  public Optional<Professor> updateProfessorById(ProfessorDTO professorDto, int professorId, int cursoId) {
    var professorModel = professorRepository.findById(professorId);
    var cursoModel = cursoRepository.findById(cursoId);

    if (professorModel.isEmpty()) {
      return Optional.empty();
    }

    if (cursoModel.isEmpty()) {
      return Optional.empty();
    }

    var updatedProfessor = professorModel.get();
    BeanUtils.copyProperties(professorDto, updatedProfessor);

    var curso = cursoModel.get();
    updatedProfessor.setCurso(curso);
    curso.setProfessor(updatedProfessor);
    cursoRepository.save(curso);

    return Optional.of(professorRepository.save(updatedProfessor));
  }

  @Transactional()
  public Optional<Professor> deleteProfessorById(int professorId) {
    var professorModel = professorRepository.findById(professorId);

    if (professorModel.isEmpty()) {
      return Optional.empty();
    }

    professorRepository.delete(professorModel.get());

    return professorModel;
  }

}
