package com.teste.projetogestaodevacinas.web.dto;

import jakarta.validation.constraints.NotNull;

public record EstoqueVacinaRequest(
    @NotNull Long vacinaId,
    @NotNull Long clinicaId,
    @NotNull Integer quantidadeDisponivel
) {}
