package com.teste.projetogestaodevacinas.web.controller;

import com.teste.projetogestaodevacinas.model.Pet;
import com.teste.projetogestaodevacinas.model.RegistroVacina;
import com.teste.projetogestaodevacinas.service.PetService;
import com.teste.projetogestaodevacinas.web.dto.PetRequest;
import com.teste.projetogestaodevacinas.web.dto.RegistroVacinaRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PetController {
    private final PetService petService;
    public PetController(PetService petService){this.petService = petService;}

    @PostMapping("/usuarios/{usuarioId}/pets")
    @ResponseStatus(HttpStatus.CREATED)
    public Pet criarPet(@PathVariable Long usuarioId, @RequestBody @Valid PetRequest req){
        return petService.cadastrarPet(usuarioId, req.nome(), req.especie(), req.idade());
    }

    @GetMapping("/usuarios/{usuarioId}/pets")
    public List<Pet> listarPetsPorUsuario(@PathVariable Long usuarioId){
        return petService.listarPorUsuario(usuarioId);
    }

    @PostMapping("/pets/{petId}/vacinas")
    @ResponseStatus(HttpStatus.CREATED)
    public RegistroVacina registrarVacina(@PathVariable Long petId, @RequestBody @Valid RegistroVacinaRequest req){
        return petService.registrarVacina(petId, req.vacinaId(), req.dataAplicacao());
    }

    @GetMapping("/pets/{petId}/vacinas")
    public List<RegistroVacina> historicoVacinas(@PathVariable Long petId){
        return petService.historicoVacinas(petId);
    }
}
