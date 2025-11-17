package com.teste.projetogestaodevacinas.repository;

import com.teste.projetogestaodevacinas.model.EstoqueVacina;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EstoqueVacinaRepository extends JpaRepository<EstoqueVacina, Long> {

    //Busca o estoque de uma vacina em uma clínica específica
    Optional<EstoqueVacina> findByClinicaIdAndVacinaId(Long clinicaId, Long vacinaId);
}
