package com.teste.projetogestaodevacinas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estoque_vacina")
public class EstoqueVacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int quantidadeDisponivel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacina_id", nullable = false)
    private Vacina vacina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinica_id", nullable = false)
    private Clinica clinica;

    // 🔹 Construtores
    public EstoqueVacina() {}

    public EstoqueVacina(Vacina vacina, Clinica clinica, int quantidadeDisponivel) {
        this.vacina = vacina;
        this.clinica = clinica;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    // 🔹 Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    // 🔹 Método utilitário para controlar o estoque
    public void reduzirEstoque(int quantidade) {
        if (quantidadeDisponivel >= quantidade) {
            this.quantidadeDisponivel -= quantidade;
        } else {
            throw new IllegalArgumentException("Estoque insuficiente para a vacina selecionada.");
        }
    }
}
