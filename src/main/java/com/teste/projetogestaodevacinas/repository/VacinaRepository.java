package com.teste.projetogestaodevacinas.repository;

import com.teste.projetogestaodevacinas.model.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface VacinaRepository extends JpaRepository<Vacina, Long> {
    Optional<Vacina> findByNome(String nome);
}
