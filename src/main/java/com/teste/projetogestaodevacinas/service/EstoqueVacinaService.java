package com.teste.projetogestaodevacinas.service;

import com.teste.projetogestaodevacinas.model.Clinica;
import com.teste.projetogestaodevacinas.model.EstoqueVacina;
import com.teste.projetogestaodevacinas.model.Vacina;
import com.teste.projetogestaodevacinas.repository.ClinicaRepository;
import com.teste.projetogestaodevacinas.repository.EstoqueVacinaRepository;
import com.teste.projetogestaodevacinas.repository.VacinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueVacinaService {

    private final EstoqueVacinaRepository estoqueVacinaRepository;
    private final ClinicaRepository clinicaRepository;
    private final VacinaRepository vacinaRepository;

    public EstoqueVacinaService(EstoqueVacinaRepository estoqueVacinaRepository,
                                ClinicaRepository clinicaRepository,
                                VacinaRepository vacinaRepository) {
        this.estoqueVacinaRepository = estoqueVacinaRepository;
        this.clinicaRepository = clinicaRepository;
        this.vacinaRepository = vacinaRepository;
    }

    //Cadastrar novo estoque
    public EstoqueVacina cadastrar(Long clinicaId, Long vacinaId, int quantidade) {
        Clinica clinica = clinicaRepository.findById(clinicaId)
                .orElseThrow(() -> new IllegalArgumentException("Clínica não encontrada: " + clinicaId));
        Vacina vacina = vacinaRepository.findById(vacinaId)
                .orElseThrow(() -> new IllegalArgumentException("Vacina não encontrada: " + vacinaId));

        EstoqueVacina estoque = new EstoqueVacina(vacina, clinica, quantidade);
        return estoqueVacinaRepository.save(estoque);
    }

    //Atualizar quantidade (ex: reposição)
    public EstoqueVacina atualizarQuantidade(Long id, int novaQuantidade) {
        EstoqueVacina estoque = estoqueVacinaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Estoque não encontrado: " + id));
        estoque.setQuantidadeDisponivel(novaQuantidade);
        return estoqueVacinaRepository.save(estoque);
    }

    //Listar todos os estoques
    public List<EstoqueVacina> listarTodos() {
        return estoqueVacinaRepository.findAll();
    }

    //Buscar por clínica
    public List<EstoqueVacina> listarPorClinica(Long clinicaId) {
        return estoqueVacinaRepository.findAll()
                .stream()
                .filter(e -> e.getClinica().getId().equals(clinicaId))
                .toList();
    }

    //Remover um item de estoque
    public void remover(Long id) {
        estoqueVacinaRepository.deleteById(id);
    }
}
