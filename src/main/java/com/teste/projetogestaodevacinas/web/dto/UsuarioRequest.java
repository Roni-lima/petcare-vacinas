package com.teste.projetogestaodevacinas.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/*** DTO usado para receber dados do usuário no POST /api/usuarios */
public record UsuarioRequest(

        // Nome obrigatório
        @NotBlank(message = "Nome é obrigatório")
        String nome,

        // Email obrigatório e validado
        @Email(message = "Email inválido")
        @NotBlank(message = "Email é obrigatório")
        String email,

        // CPF obrigatório no formato 000.000.000-00
        @NotBlank(message = "CPF é obrigatório")
        @Pattern(
                regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}",
                message = "CPF deve estar no formato 000.000.000-00"
        )
        String cpf,

        // Telefone opcional
        String telefone
) {}
