package com.teste.projetogestaodevacinas.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record VeterinarioRequest(
    @NotBlank String nome,
    @Email @NotBlank String email,
    String telefone,
    @NotBlank String crm,
    Long clinicaId
) {}
