package com.teste.projetogestaodevacinas.web.controller;

import com.teste.projetogestaodevacinas.model.Veterinario;
import com.teste.projetogestaodevacinas.repository.VeterinarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/veterinarios")
public class VeterinarioController {

    private final VeterinarioRepository veterinarioRepository;

    public VeterinarioController(VeterinarioRepository veterinarioRepository) {
        this.veterinarioRepository = veterinarioRepository;
    }

    //Cadastrar veterinário
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veterinario cadastrar(@RequestBody Veterinario veterinario) {
        return veterinarioRepository.save(veterinario);
    }

    //Listar todos os veterinários
    @GetMapping
    public List<Veterinario> listar() {
        return veterinarioRepository.findAll();
    }

    //Buscar veterinário por ID
    @GetMapping("/{id}")
    public ResponseEntity<Veterinario> buscarPorId(@PathVariable Long id) {
        Optional<Veterinario> vet = veterinarioRepository.findById(id);
        return vet.map(ResponseEntity::ok)
                  .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
