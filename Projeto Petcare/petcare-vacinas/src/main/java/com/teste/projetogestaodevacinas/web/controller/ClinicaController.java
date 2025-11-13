package com.teste.projetogestaodevacinas.web.controller;

import com.teste.projetogestaodevacinas.model.Clinica;
import com.teste.projetogestaodevacinas.service.ClinicaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clinicas")
public class ClinicaController {

    private final ClinicaService clinicaService;

    public ClinicaController(ClinicaService clinicaService) {
        this.clinicaService = clinicaService;
    }

    // ➕ Cadastrar nova clínica
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Clinica cadastrar(@RequestBody Clinica clinica) {
        return clinicaService.cadastrar(clinica);
    }

    //Listar todas as clínicas
    @GetMapping
    public List<Clinica> listarTodas() {
        return clinicaService.listarTodas();
    }

    //Buscar clínica por ID
    @GetMapping("/{id}")
    public Clinica buscarPorId(@PathVariable Long id) {
        return clinicaService.buscarPorId(id);
    }

    //Atualizar clínica
    @PutMapping("/{id}")
    public Clinica atualizar(@PathVariable Long id, @RequestBody Clinica clinicaAtualizada) {
        return clinicaService.atualizar(id, clinicaAtualizada);
    }

    //Remover clínica
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        clinicaService.remover(id);
    }
}
