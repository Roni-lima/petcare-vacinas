package com.teste.projetogestaodevacinas.web.controller;

import com.teste.projetogestaodevacinas.model.RegistroVacina;
import com.teste.projetogestaodevacinas.service.PetService;
import com.teste.projetogestaodevacinas.repository.RegistroVacinaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/registro-vacinas")
public class RegistroVacinaController {

    private final RegistroVacinaRepository registroVacinaRepository;
    private final PetService petService;

    public RegistroVacinaController(RegistroVacinaRepository registroVacinaRepository, PetService petService) {
        this.registroVacinaRepository = registroVacinaRepository;
        this.petService = petService;
    }

    //Listar todos os registros
    @GetMapping
    public List<RegistroVacina> listarTodos() {
        return registroVacinaRepository.findAll();
    }

    //Buscar registros por pet
    @GetMapping("/pet/{petId}")
    public List<RegistroVacina> listarPorPet(@PathVariable Long petId) {
        return registroVacinaRepository.findByPetId(petId);
    }

    //Buscar registros por veterinário
    @GetMapping("/veterinario/{veterinarioId}")
    public List<RegistroVacina> listarPorVeterinario(@PathVariable Long veterinarioId) {
        return registroVacinaRepository.findByVeterinarioId(veterinarioId);
    }

    //Buscar registros por vacina
    @GetMapping("/vacina/{vacinaId}")
    public List<RegistroVacina> listarPorVacina(@PathVariable Long vacinaId) {
        return registroVacinaRepository.findByVacinaId(vacinaId);
    }

    // ➕ Registrar nova aplicação de vacina (modo direto)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RegistroVacina registrarVacinaDireto(
            @RequestParam Long petId,
            @RequestParam Long vacinaId,
            @RequestParam Long veterinarioId,
            @RequestParam String dataAplicacao,
            @RequestParam(required = false) String dose,
            @RequestParam(required = false) String observacao
    ) {
        LocalDate data = LocalDate.parse(dataAplicacao);
        return petService.registrarVacina(petId, vacinaId, veterinarioId, data, dose, observacao);
    }

    //Excluir registro (em caso de erro)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerRegistro(@PathVariable Long id) {
        registroVacinaRepository.deleteById(id);
    }
}
