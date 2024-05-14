package com.laranjeirosgroup.ac2.Controllers;

import com.laranjeirosgroup.ac2.Dtos.ProfessorDTO;
import com.laranjeirosgroup.ac2.Models.Professor;
import com.laranjeirosgroup.ac2.Services.ProfessorService;
import com.laranjeirosgroup.ac2.enums.Especializacao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

  @Autowired()
  private ProfessorService professorService;

  @PostMapping()
  public ResponseEntity<Object> register(@RequestBody @Valid ProfessorDTO professorDTO) {
    return ResponseEntity.status(HttpStatus.OK).body(professorService.registerProfessor(professorDTO, professorDTO.curso()));
  }

  @GetMapping("/especializacao/{especializacao}")
  public List<Professor> buscarProfessoresPorEspecializacao(@PathVariable Especializacao especializacao) {
    return professorService.buscarProfessoresPorEspecializacao(especializacao);
  }

  @GetMapping()
  public ResponseEntity<List<Professor>> getAllProfessores() {
    return ResponseEntity.status(HttpStatus.OK).body(professorService.getAllProfessores());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getProfessorById(@PathVariable(value = "id") int professorId) {
    Optional<Professor> professorModel = professorService.getProfessorById(professorId);

    if (professorModel.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professor id not found");
    }

    return ResponseEntity.status(HttpStatus.OK).body(professorModel);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> updateProfessorById(@RequestBody @Valid ProfessorDTO professorDto,
    @PathVariable(value = "id") int professorId) {

    Optional<Professor> professorModel = professorService.updateProfessorById(professorDto, professorId, professorDto.curso());

    if (professorModel.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professor id not found");
    }

    return ResponseEntity.status(HttpStatus.OK).body(professorModel);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteProfessorById(@PathVariable(value = "id") int professorId) {
    Optional<Professor> professorModel = professorService.deleteProfessorById(professorId);

    if (professorModel.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professor id not found");
    }

    return ResponseEntity.status(HttpStatus.OK).body("Professor deleted successfuly");
  }

}
