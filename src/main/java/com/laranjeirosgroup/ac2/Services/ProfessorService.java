package com.laranjeirosgroup.ac2.Services;

import com.laranjeirosgroup.ac2.Dtos.ProfessorDTO;
import com.laranjeirosgroup.ac2.Models.Professor;
import com.laranjeirosgroup.ac2.Repositories.ProfessorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

  @Autowired()
  private ProfessorRepository professorRepository;

  @Transactional()
  public Professor registerProfessor(ProfessorDTO professorDTO) {
    var newProfessor = new Professor();
    BeanUtils.copyProperties(professorDTO, newProfessor);

    return professorRepository.save(newProfessor);
  }

  public List<Professor> getAllProfessores() {
    return professorRepository.findAll();
  }

  public Optional<Professor> getProfessorById(int professorId) {
    return professorRepository.findById(professorId);
  }

  @Transactional()
  public Optional<Professor> updateProfessorById(ProfessorDTO professorDto, int professorId) {
    var professorModel = professorRepository.findById(professorId);

    if (professorModel.isEmpty()) {
      return Optional.empty();
    }

    var updatedProfessor = professorModel.get();
    BeanUtils.copyProperties(professorDto, updatedProfessor);

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
