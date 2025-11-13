package com.teste.projetogestaodevacinas.web.dto;
import jakarta.validation.constraints.NotBlank;

public record VacinaRequest(
    @NotBlank String nome,
    String fabricante
) {

    public String nºDosagem() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nºDosagem'");
    }}
