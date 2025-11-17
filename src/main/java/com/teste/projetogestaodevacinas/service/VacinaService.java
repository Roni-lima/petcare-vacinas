package com.teste.projetogestaodevacinas.service;

import com.teste.projetogestaodevacinas.model.Vacina;
import com.teste.projetogestaodevacinas.repository.VacinaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VacinaService {

    private final VacinaRepository vacinaRepository;

    public VacinaService(VacinaRepository vacinaRepository) {
        this.vacinaRepository = vacinaRepository;
    }

    public Vacina cadastrar(Vacina vacina) {
        return vacinaRepository.save(vacina);
    }

    public List<Vacina> listarTodas() {
        return vacinaRepository.findAll();
    }

    public Vacina buscarPorId(Long id) {
        return vacinaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vacina não encontrada: " + id));
    }

    public void remover(Long id) {
        vacinaRepository.deleteById(id);
    }
}
