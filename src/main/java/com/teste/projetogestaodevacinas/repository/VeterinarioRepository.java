package com.teste.projetogestaodevacinas.repository;

import com.teste.projetogestaodevacinas.model.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
}
