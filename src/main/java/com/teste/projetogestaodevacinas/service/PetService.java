package com.teste.projetogestaodevacinas.service;

import com.teste.projetogestaodevacinas.model.*;
import com.teste.projetogestaodevacinas.repository.*;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class PetService {
    private final PetRepository petRepository;
    private final UsuarioService usuarioService;
    private final VacinaRepository vacinaRepository;
    private final RegistroVacinaRepository registroVacinaRepository;

    public PetService(PetRepository petRepository, UsuarioService usuarioService,
                      VacinaRepository vacinaRepository, RegistroVacinaRepository registroVacinaRepository){
        this.petRepository = petRepository;
        this.usuarioService = usuarioService;
        this.vacinaRepository = vacinaRepository;
        this.registroVacinaRepository = registroVacinaRepository;
    }

    public Pet cadastrarPet(Long usuarioId, String nome, String especie, Integer idade){
        Usuario dono = usuarioService.buscarPorId(usuarioId);
        Pet pet = new Pet(nome, especie, idade, dono);
        return petRepository.save(pet);
    }

    public List<Pet> listarPorUsuario(Long usuarioId){
        return petRepository.findByDonoId(usuarioId);
    }

    public RegistroVacina registrarVacina(Long petId, Long vacinaId, LocalDate dataAplicacao){
        Pet pet = petRepository.findById(petId).orElseThrow(()-> new IllegalArgumentException("Pet não encontrado: "+petId));
        Vacina vacina = vacinaRepository.findById(vacinaId).orElseThrow(()-> new IllegalArgumentException("Vacina não encontrada: "+vacinaId));
        RegistroVacina reg = new RegistroVacina(pet, vacina, dataAplicacao);
        return registroVacinaRepository.save(reg);
    }

    public List<RegistroVacina> historicoVacinas(Long petId){
        return registroVacinaRepository.findByPetId(petId);
    }
}
