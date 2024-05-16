package com.laranjeirosgroup.ac2.Services;

import com.laranjeirosgroup.ac2.Dtos.AgendaDTO;
import com.laranjeirosgroup.ac2.Models.Agenda;
import com.laranjeirosgroup.ac2.Models.Curso;
import com.laranjeirosgroup.ac2.Models.Professor;
import com.laranjeirosgroup.ac2.Repositories.AgendaRepository;
import com.laranjeirosgroup.ac2.Repositories.CursoRepository;
import com.laranjeirosgroup.ac2.Repositories.ProfessorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AgendaService {

  @Autowired()
  private AgendaRepository agendaRepository;

  @Autowired()
  private ProfessorRepository professorRepository;

  @Autowired()
  private CursoRepository cursoRepository;

  @Transactional()
  public Agenda registerAgenda(AgendaDTO agendaDTO, int professorId, int cursoId) {
    var newAgenda = new Agenda();
    BeanUtils.copyProperties(agendaDTO, newAgenda);

    Optional<Professor> optionalProfessor = professorRepository.findById(professorId);
    if (optionalProfessor.isPresent()) {
      Professor professor = optionalProfessor.get();
      newAgenda.setProfessor(professor);
      professor.setAgenda(newAgenda);
      professorRepository.save(professor);
    }

    Optional<Curso> optionalCurso = cursoRepository.findById(cursoId);
    if (optionalCurso.isPresent()) {
      Curso curso = optionalCurso.get();
      newAgenda.setCurso(curso);
      curso.setAgenda(newAgenda);
      cursoRepository.save(curso);
    }

    return agendaRepository.save(newAgenda);
  }

  public List<Agenda> buscarAgendasPorProfessor(int professorId) {
    return agendaRepository.findByProfessorId(professorId);
  }

  public boolean isAgendaLotada(int professorId, LocalDateTime inicio, LocalDateTime fim) {
    return agendaRepository.isAgendaLotada(professorId, inicio, fim);
  }

  public List<Agenda> getAllAgendas() {
    return agendaRepository.findAll();
  }

  public Optional<Agenda> getAgendaById(int agendaId) {
    return agendaRepository.findById(agendaId);
  }

  @Transactional()
  public Optional<Agenda> updateAgendaById(AgendaDTO agendaDto, int agendaId, int professorId, int cursoId) {
    var agendaModel = agendaRepository.findById(agendaId);
    var professorModel = professorRepository.findById(professorId);
    var cursoModel = cursoRepository.findById(cursoId);

    if (agendaModel.isEmpty()) {
      return Optional.empty();
    }

    if (professorModel.isEmpty()) {
      return Optional.empty();
    }

    if (cursoModel.isEmpty()) {
      return Optional.empty();
    }

    var updatedAgenda = agendaModel.get();
    BeanUtils.copyProperties(agendaDto, updatedAgenda);

    var curso = cursoModel.get();
    updatedAgenda.setCurso(curso);
    curso.setAgenda(updatedAgenda);
    cursoRepository.save(curso);

    var professor = professorModel.get();
    updatedAgenda.setProfessor(professor);
    professor.setAgenda(updatedAgenda);
    professorRepository.save(professor);

    return Optional.of(agendaRepository.save(updatedAgenda));
  }

  @Transactional()
  public Optional<Agenda> deleteAgendaById(int agendaId) {
    var agendaModel = agendaRepository.findById(agendaId);

    if (agendaModel.isEmpty()) {
      return Optional.empty();
    }

    agendaRepository.delete(agendaModel.get());

    return agendaModel;
  }

  @Transactional()
  public Optional<Agenda> registerResumo(int agendaId, String resumoTreinamento) {
    var agendaModel = agendaRepository.findById(agendaId);

    if (agendaModel.isEmpty()) {
      return Optional.empty();
    }

    var agenda = agendaModel.get();
    agenda.setResumoTreinamento(resumoTreinamento);
    agendaRepository.save(agenda);

    return Optional.of(agendaRepository.save(agenda));
  }

}
