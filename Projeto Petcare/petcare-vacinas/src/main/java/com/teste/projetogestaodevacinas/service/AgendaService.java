package com.teste.projetogestaodevacinas.service;

import com.teste.projetogestaodevacinas.model.Agenda;
import com.teste.projetogestaodevacinas.model.Pet;
import com.teste.projetogestaodevacinas.repository.AgendaRepository;
import com.teste.projetogestaodevacinas.repository.PetRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class AgendaService {
    private final AgendaRepository agendaRepository;
    private final PetRepository petRepository;

    public AgendaService(AgendaRepository agendaRepository, PetRepository petRepository){
        this.agendaRepository = agendaRepository;
        this.petRepository = petRepository;
    }

    public Agenda agendar(Long petId, LocalDate data, String tipo, String status, String obs){
        Pet pet = petRepository.findById(petId).orElseThrow(()-> new IllegalArgumentException("Pet não encontrado: "+petId));
        Agenda a = new Agenda(pet, data, tipo, status, obs);
        return agendaRepository.save(a);
    }

    public List<Agenda> listarPorPet(Long petId){return agendaRepository.findByPetId(petId);}
}
