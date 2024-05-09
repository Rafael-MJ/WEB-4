package com.laranjeirosgroup.ac2.Services;

import com.laranjeirosgroup.ac2.Dtos.AgendaDTO;
import com.laranjeirosgroup.ac2.Models.Agenda;
import com.laranjeirosgroup.ac2.Repositories.AgendaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaService {

  @Autowired()
  private AgendaRepository agendaRepository;

  @Transactional()
  public Agenda registerAgenda(AgendaDTO agendaDTO) {
    var newAgenda = new Agenda();
    BeanUtils.copyProperties(agendaDTO, newAgenda);

    return agendaRepository.save(newAgenda);
  }

  public List<Agenda> getAllAgendas() {
    return agendaRepository.findAll();
  }

  public Optional<Agenda> getAgendaById(int agendaId) {
    return agendaRepository.findById(agendaId);
  }

  @Transactional()
  public Optional<Agenda> updateAgendaById(AgendaDTO agendaDto, int agendaId) {
    var agendaModel = agendaRepository.findById(agendaId);

    if (agendaModel.isEmpty()) {
      return Optional.empty();
    }

    var updatedAgenda = agendaModel.get();
    BeanUtils.copyProperties(agendaDto, updatedAgenda);

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

}
