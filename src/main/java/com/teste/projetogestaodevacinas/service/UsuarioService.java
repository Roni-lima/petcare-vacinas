package com.teste.projetogestaodevacinas.service;

import com.teste.projetogestaodevacinas.model.Usuario;
import com.teste.projetogestaodevacinas.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    public UsuarioService(UsuarioRepository usuarioRepository){this.usuarioRepository = usuarioRepository;}
    public Usuario criar(Usuario u){return usuarioRepository.save(u);}
    public List<Usuario> listar(){return usuarioRepository.findAll();}
    public Usuario buscarPorId(Long id){return usuarioRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Usuário não encontrado: "+id));}
}
