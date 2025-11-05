package com.teste.projetogestaodevacinas.web.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PetRequest(
    @NotBlank String nome,
    @NotBlank String especie,
    @NotNull Integer idade
) {}
