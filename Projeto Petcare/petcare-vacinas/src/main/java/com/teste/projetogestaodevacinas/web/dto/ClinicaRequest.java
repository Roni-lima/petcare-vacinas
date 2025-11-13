package com.teste.projetogestaodevacinas.web.dto;

import jakarta.validation.constraints.NotBlank;

public record ClinicaRequest(
    @NotBlank String nome,
    @NotBlank String endereco,
    String telefone
) {}
