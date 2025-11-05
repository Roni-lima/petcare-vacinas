package com.teste.projetogestaodevacinas.web.dto;
import jakarta.validation.constraints.NotBlank;

public record VacinaRequest(
    @NotBlank String nome,
    String fabricante
) {}
