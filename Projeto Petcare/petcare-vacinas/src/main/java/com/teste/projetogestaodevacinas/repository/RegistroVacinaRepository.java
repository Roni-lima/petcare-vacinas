package com.teste.projetogestaodevacinas.repository;

import com.teste.projetogestaodevacinas.model.RegistroVacina;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RegistroVacinaRepository extends JpaRepository<RegistroVacina, Long> {

    //Busca registros por ID do pet
    List<RegistroVacina> findByPetId(Long petId);

    //Busca registros por ID do veterinário
    List<RegistroVacina> findByVeterinarioId(Long veterinarioId);

    //Busca registros por ID da vacina
    List<RegistroVacina> findByVacinaId(Long vacinaId);
}
