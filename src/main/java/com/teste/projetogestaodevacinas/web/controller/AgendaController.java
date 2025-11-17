package com.teste.projetogestaodevacinas.web.controller;

import com.teste.projetogestaodevacinas.model.Agenda;
import com.teste.projetogestaodevacinas.service.AgendaService;
import com.teste.projetogestaodevacinas.web.dto.AgendaRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pets/{petId}/agenda")
public class AgendaController {
    private final AgendaService agendaService;
    public AgendaController(AgendaService agendaService){this.agendaService = agendaService;}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Agenda agendar(@PathVariable Long petId, @RequestBody @Valid AgendaRequest req){
        return agendaService.agendar(petId, req.dataAgendada(), req.tipo(), req.status(), req.observacao());
    }

    @GetMapping
    public List<Agenda> listar(@PathVariable Long petId){ return agendaService.listarPorPet(petId); }
}
