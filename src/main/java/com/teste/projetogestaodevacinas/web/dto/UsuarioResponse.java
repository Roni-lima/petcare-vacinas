package com.teste.projetogestaodevacinas.web.dto;

/*** DTO usado para devolver dados ao cliente
 * Não retornamos a entidade diretamente por segurança.
 */
public record UsuarioResponse(
        Long id,
        String nome,
        String email,
        String cpf,
        String telefone
) {}
