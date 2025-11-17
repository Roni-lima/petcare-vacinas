package com.teste.projetogestaodevacinas.web.controller;

import com.teste.projetogestaodevacinas.model.EstoqueVacina;
import com.teste.projetogestaodevacinas.service.EstoqueVacinaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueVacinaController {

    private final EstoqueVacinaService estoqueVacinaService;

    public EstoqueVacinaController(EstoqueVacinaService estoqueVacinaService) {
        this.estoqueVacinaService = estoqueVacinaService;
    }

    //Cadastrar novo item de estoque
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EstoqueVacina cadastrar(@RequestParam Long clinicaId,
                                   @RequestParam Long vacinaId,
                                   @RequestParam int quantidade) {
        return estoqueVacinaService.cadastrar(clinicaId, vacinaId, quantidade);
    }

    //Listar todos
    @GetMapping
    public List<EstoqueVacina> listar() {
        return estoqueVacinaService.listarTodos();
    }

    //Listar por clínica
    @GetMapping("/clinica/{clinicaId}")
    public List<EstoqueVacina> listarPorClinica(@PathVariable Long clinicaId) {
        return estoqueVacinaService.listarPorClinica(clinicaId);
    }

    //Atualizar quantidade
    @PutMapping("/{id}")
    public EstoqueVacina atualizarQuantidade(@PathVariable Long id, @RequestParam int novaQuantidade) {
        return estoqueVacinaService.atualizarQuantidade(id, novaQuantidade);
    }

    //Remover item
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        estoqueVacinaService.remover(id);
    }
}
