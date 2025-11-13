package com.teste.projetogestaodevacinas.web.dto;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record RegistroVacinaRequest(
    @NotNull Long vacinaId,
    @NotNull LocalDate dataAplicacao
) {}
