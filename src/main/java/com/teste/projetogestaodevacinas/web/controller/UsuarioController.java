package com.teste.projetogestaodevacinas.web.controller;

import com.teste.projetogestaodevacinas.model.Usuario;
import com.teste.projetogestaodevacinas.service.UsuarioService;
import com.teste.projetogestaodevacinas.web.dto.UsuarioRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService){this.usuarioService = usuarioService;}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario criar(@RequestBody @Valid UsuarioRequest req){
        Usuario u = new Usuario(req.nome(), req.email(), req.cpf(), req.telefone());
        return usuarioService.criar(u);
    }

    @GetMapping
    public List<Usuario> listar(){ return usuarioService.listar(); }
}
