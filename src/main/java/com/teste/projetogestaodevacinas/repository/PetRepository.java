package com.teste.projetogestaodevacinas.repository;

import com.teste.projetogestaodevacinas.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByDonoId(Long usuarioId);
}
