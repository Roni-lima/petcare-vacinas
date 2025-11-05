package com.teste.projetogestaodevacinas.repository;

import com.teste.projetogestaodevacinas.model.RegistroVacina;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RegistroVacinaRepository extends JpaRepository<RegistroVacina, Long> {
    List<RegistroVacina> findByPetId(Long petId);
}
