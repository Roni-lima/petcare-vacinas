package com.teste.projetogestaodevacinas.service;

import com.teste.projetogestaodevacinas.model.Veterinario;
import com.teste.projetogestaodevacinas.repository.VeterinarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinarioService {

    private final VeterinarioRepository veterinarioRepository;

    public VeterinarioService(VeterinarioRepository veterinarioRepository) {
        this.veterinarioRepository = veterinarioRepository;
    }

    public Veterinario cadastrar(Veterinario veterinario) {
        return veterinarioRepository.save(veterinario);
    }

    public List<Veterinario> listarTodos() {
        return veterinarioRepository.findAll();
    }

    public Veterinario buscarPorId(Long id) {
        return veterinarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Veterinário não encontrado: " + id));
    }

    public void remover(Long id) {
        veterinarioRepository.deleteById(id);
    }
}
