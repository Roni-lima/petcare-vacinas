package com.teste.projetogestaodevacinas.service;

import com.teste.projetogestaodevacinas.model.*;
import com.teste.projetogestaodevacinas.repository.*;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class RegistroVacinaService {

    private final RegistroVacinaRepository registroVacinaRepository;
    private final PetRepository petRepository;
    private final VacinaRepository vacinaRepository;
    private final VeterinarioRepository veterinarioRepository;

    public RegistroVacinaService(RegistroVacinaRepository registroVacinaRepository,
                                 PetRepository petRepository,
                                 VacinaRepository vacinaRepository,
                                 VeterinarioRepository veterinarioRepository) {
        this.registroVacinaRepository = registroVacinaRepository;
        this.petRepository = petRepository;
        this.vacinaRepository = vacinaRepository;
        this.veterinarioRepository = veterinarioRepository;
    }

    public RegistroVacina registrar(Long petId, Long vacinaId, Long veterinarioId,
                                    LocalDate data, String dose, String observacao) {

        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new IllegalArgumentException("Pet não encontrado: " + petId));

        Vacina vacina = vacinaRepository.findById(vacinaId)
                .orElseThrow(() -> new IllegalArgumentException("Vacina não encontrada: " + vacinaId));

        Veterinario vet = veterinarioRepository.findById(veterinarioId)
                .orElseThrow(() -> new IllegalArgumentException("Veterinário não encontrado: " + veterinarioId));

        RegistroVacina registro = new RegistroVacina(pet, vacina, vet, data, dose, observacao);
        return registroVacinaRepository.save(registro);
    }

    public List<RegistroVacina> listarPorPet(Long petId) {
        return registroVacinaRepository.findByPetId(petId);
    }

    public List<RegistroVacina> listarPorVeterinario(Long vetId) {
        return registroVacinaRepository.findByVeterinarioId(vetId);
    }
}
