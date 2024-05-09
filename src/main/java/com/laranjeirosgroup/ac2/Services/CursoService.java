package com.laranjeirosgroup.ac2.Services;

import com.laranjeirosgroup.ac2.Dtos.CursoDTO;
import com.laranjeirosgroup.ac2.Models.Curso;
import com.laranjeirosgroup.ac2.Repositories.CursoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

  @Autowired()
  private CursoRepository cursoRepository;

  @Transactional()
  public Curso registerCurso(CursoDTO cursoDTO) {
    var newCurso = new Curso();
    BeanUtils.copyProperties(cursoDTO, newCurso);

    return cursoRepository.save(newCurso);
  }

  public List<Curso> getAllCursos() {
    return cursoRepository.findAll();
  }

  public Optional<Curso> getCursoById(int cursoId) {
    return cursoRepository.findById(cursoId);
  }

  @Transactional()
  public Optional<Curso> updateCursoById(CursoDTO cursoDto, int cursoId) {
    var cursoModel = cursoRepository.findById(cursoId);

    if (cursoModel.isEmpty()) {
      return Optional.empty();
    }

    var updatedCurso = cursoModel.get();
    BeanUtils.copyProperties(cursoDto, updatedCurso);

    return Optional.of(cursoRepository.save(updatedCurso));
  }

  @Transactional()
  public Optional<Curso> deleteCursoById(int cursoId) {
    var cursoModel = cursoRepository.findById(cursoId);

    if (cursoModel.isEmpty()) {
      return Optional.empty();
    }

    cursoRepository.delete(cursoModel.get());

    return cursoModel;
  }

}
