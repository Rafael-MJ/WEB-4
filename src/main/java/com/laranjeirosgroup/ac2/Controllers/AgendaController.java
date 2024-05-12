package com.laranjeirosgroup.ac2.Controllers;

import com.laranjeirosgroup.ac2.Dtos.AgendaDTO;
import com.laranjeirosgroup.ac2.Models.Agenda;
import com.laranjeirosgroup.ac2.Services.AgendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agendas")
public class AgendaController {

  @Autowired()
  private AgendaService agendaService;

  @PostMapping()
  public ResponseEntity<Object> register(@RequestBody @Valid AgendaDTO agendaDTO) {
    return ResponseEntity.status(HttpStatus.OK).body(agendaService.registerAgenda(agendaDTO, agendaDTO.professor(), agendaDTO.curso()));
  }

  @GetMapping()
  public ResponseEntity<List<Agenda>> getAllAgendas() {
    return ResponseEntity.status(HttpStatus.OK).body(agendaService.getAllAgendas());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getAgendaById(@PathVariable(value = "id") int agendaId) {
    Optional<Agenda> agendaModel = agendaService.getAgendaById(agendaId);

    if (agendaModel.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agenda id not found");
    }

    return ResponseEntity.status(HttpStatus.OK).body(agendaModel);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> updateAgendaById(@RequestBody @Valid AgendaDTO agendaDto,
                                                    @PathVariable(value = "id") int agendaId) {

    Optional<Agenda> agendaModel = agendaService.updateAgendaById(agendaDto, agendaId);

    if (agendaModel.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agenda id not found");
    }

    return ResponseEntity.status(HttpStatus.OK).body(agendaModel);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteAgendaById(@PathVariable(value = "id") int agendaId) {
    Optional<Agenda> agendaModel = agendaService.deleteAgendaById(agendaId);

    if (agendaModel.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agenda id not found");
    }

    return ResponseEntity.status(HttpStatus.OK).body("Agenda deleted successfuly");
  }

}
