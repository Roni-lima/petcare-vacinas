package com.teste.projetogestaodevacinas.web.dto;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record AgendaRequest(
    @NotNull @FutureOrPresent LocalDate dataAgendada,
    @NotBlank String tipo,
    @NotBlank String status,
    String observacao
) {}
