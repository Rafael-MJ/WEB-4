package com.laranjeirosgroup.ac2.Controllers;

import com.laranjeirosgroup.ac2.Dtos.CursoDTO;
import com.laranjeirosgroup.ac2.Models.Curso;
import com.laranjeirosgroup.ac2.Services.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoController {

  @Autowired()
  private CursoService cursoService;

  @PostMapping()
  public ResponseEntity<Object> register(@RequestBody @Valid CursoDTO cursoDTO) {
    return ResponseEntity.status(HttpStatus.OK).body(cursoService.registerCurso(cursoDTO));
  }

  @GetMapping()
  public ResponseEntity<List<Curso>> getAllCursos() {
    return ResponseEntity.status(HttpStatus.OK).body(cursoService.getAllCursos());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getCursoById(@PathVariable(value = "id") int cursoId) {
    Optional<Curso> cursoModel = cursoService.getCursoById(cursoId);

    if (cursoModel.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso id not found");
    }

    return ResponseEntity.status(HttpStatus.OK).body(cursoModel);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> updateCursoById(@RequestBody @Valid CursoDTO cursoDto,
                                                    @PathVariable(value = "id") int cursoId) {

    Optional<Curso> cursoModel = cursoService.updateCursoById(cursoDto, cursoId);

    if (cursoModel.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso id not found");
    }

    return ResponseEntity.status(HttpStatus.OK).body(cursoModel);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteCursoById(@PathVariable(value = "id") int cursoId) {
    Optional<Curso> cursoModel = cursoService.deleteCursoById(cursoId);

    if (cursoModel.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso id not found");
    }

    return ResponseEntity.status(HttpStatus.OK).body("Curso deleted successfuly");
  }

}
