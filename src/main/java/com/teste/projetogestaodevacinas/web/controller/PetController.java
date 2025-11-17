package com.teste.projetogestaodevacinas.web.controller;

import com.teste.projetogestaodevacinas.model.Pet;
import com.teste.projetogestaodevacinas.model.RegistroVacina;
import com.teste.projetogestaodevacinas.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    // ➕ Cadastrar novo pet
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pet cadastrarPet(@RequestParam Long usuarioId,
                            @RequestParam String nome,
                            @RequestParam String especie,
                            @RequestParam Integer idade) {
        return petService.cadastrarPet(usuarioId, nome, especie, idade);
    }

    // 📋 Listar pets por usuário
    @GetMapping("/usuario/{usuarioId}")
    public List<Pet> listarPorUsuario(@PathVariable Long usuarioId) {
        return petService.listarPorUsuario(usuarioId);
    }

    // 🧾 Histórico de vacinas de um pet
    @GetMapping("/{petId}/vacinas")
    public List<RegistroVacina> historicoVacinas(@PathVariable Long petId) {
        return petService.historicoVacinas(petId);
    }

    // 💉 Registrar vacina (com veterinário e controle de estoque)
    @PostMapping("/{petId}/registrar-vacina")
    @ResponseStatus(HttpStatus.CREATED)
    public RegistroVacina registrarVacina(
            @PathVariable Long petId,
            @RequestParam Long vacinaId,
            @RequestParam Long veterinarioId,
            @RequestParam String dataAplicacao,
            @RequestParam(required = false) String dose,
            @RequestParam(required = false) String observacao
    ) {
        LocalDate data = LocalDate.parse(dataAplicacao);
        return petService.registrarVacina(petId, vacinaId, veterinarioId, data, dose, observacao);
    }
}
