package com.teste.projetogestaodevacinas.service;

import com.teste.projetogestaodevacinas.model.Clinica;
import com.teste.projetogestaodevacinas.repository.ClinicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicaService {

    private final ClinicaRepository clinicaRepository;

    public ClinicaService(ClinicaRepository clinicaRepository) {
        this.clinicaRepository = clinicaRepository;
    }

    //Cadastrar nova clínica
    public Clinica cadastrar(Clinica clinica) {
        return clinicaRepository.save(clinica);
    }

    //Listar todas as clínicas
    public List<Clinica> listarTodas() {
        return clinicaRepository.findAll();
    }

    //Buscar clínica por ID
    public Clinica buscarPorId(Long id) {
        return clinicaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Clínica não encontrada: " + id));
    }

    //Atualizar dados da clínica
    public Clinica atualizar(Long id, Clinica clinicaAtualizada) {
        Clinica clinica = buscarPorId(id);
        clinica.setNome(clinicaAtualizada.getNome());
        clinica.setEndereco(clinicaAtualizada.getEndereco());
        clinica.setTelefone(clinicaAtualizada.getTelefone());
        return clinicaRepository.save(clinica);
    }

    //Remover clínica
    public void remover(Long id) {
        clinicaRepository.deleteById(id);
    }
}
