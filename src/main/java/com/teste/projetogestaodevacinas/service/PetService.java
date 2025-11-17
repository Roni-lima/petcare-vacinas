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
    private final VeterinarioRepository veterinarioRepository;
    private final EstoqueVacinaRepository estoqueVacinaRepository;

    public PetService(PetRepository petRepository,
                      UsuarioService usuarioService,
                      VacinaRepository vacinaRepository,
                      RegistroVacinaRepository registroVacinaRepository,
                      VeterinarioRepository veterinarioRepository,
                      EstoqueVacinaRepository estoqueVacinaRepository) {
        this.petRepository = petRepository;
        this.usuarioService = usuarioService;
        this.vacinaRepository = vacinaRepository;
        this.registroVacinaRepository = registroVacinaRepository;
        this.veterinarioRepository = veterinarioRepository;
        this.estoqueVacinaRepository = estoqueVacinaRepository;
    }

    //Cadastrar Pet
    public Pet cadastrarPet(Long usuarioId, String nome, String especie, Integer idade) {
        Usuario dono = usuarioService.buscarPorId(usuarioId);
        Pet pet = new Pet(nome, especie, idade, dono);
        return petRepository.save(pet);
    }

    //Listar pets do usuário
    public List<Pet> listarPorUsuario(Long usuarioId) {
        return petRepository.findByDonoId(usuarioId);
    }

    //Histórico de vacinas do pet
    public List<RegistroVacina> historicoVacinas(Long petId) {
        return registroVacinaRepository.findByPetId(petId);
    }

    //Registrar vacina com veterinário e controle de estoque
    public RegistroVacina registrarVacina(Long petId, Long vacinaId, Long veterinarioId,
                                          LocalDate dataAplicacao, String dose, String observacao) throws IllegalStateException {

        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new IllegalArgumentException("Pet não encontrado: " + petId));
        Vacina vacina = vacinaRepository.findById(vacinaId)
                .orElseThrow(() -> new IllegalArgumentException("Vacina não encontrada: " + vacinaId));
        Veterinario veterinario = veterinarioRepository.findById(veterinarioId)
                .orElseThrow(() -> new IllegalArgumentException("Veterinário não encontrado: " + veterinarioId));

        //Verifica estoque da clínica do veterinário
        EstoqueVacina estoque = estoqueVacinaRepository
                .findByClinicaIdAndVacinaId(veterinario.getClinica().getId(), vacinaId)
                .orElseThrow(() -> new IllegalStateException("Vacina não disponível no estoque da clínica."));

        if (estoque.getQuantidadeDisponivel() <= 0) {
            throw new IllegalStateException("Estoque insuficiente para a vacina " + vacina.getNome());
        }

        //Reduz estoque
        estoque.setQuantidadeDisponivel(estoque.getQuantidadeDisponivel() - 1);
        estoqueVacinaRepository.save(estoque);

        //Registra aplicação
        RegistroVacina registro = new RegistroVacina(
                pet, vacina, veterinario, dataAplicacao, dose, observacao
        );
        return registroVacinaRepository.save(registro);
    }
}
