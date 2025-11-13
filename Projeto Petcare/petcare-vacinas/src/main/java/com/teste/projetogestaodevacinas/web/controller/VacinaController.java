package com.teste.projetogestaodevacinas.web.controller;

import com.teste.projetogestaodevacinas.model.Vacina;
import com.teste.projetogestaodevacinas.repository.VacinaRepository;
import com.teste.projetogestaodevacinas.web.dto.VacinaRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vacinas")
public class VacinaController {
    private final VacinaRepository vacinaRepository;
    public VacinaController(VacinaRepository vacinaRepository){this.vacinaRepository = vacinaRepository;}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vacina criar(@RequestBody @Valid VacinaRequest req){
        Vacina v = new Vacina(req.nome(), req.fabricante(), req.nºDosagem());
        return vacinaRepository.save(v);
    }

    @GetMapping
    public List<Vacina> listar(){ return vacinaRepository.findAll(); }
}
