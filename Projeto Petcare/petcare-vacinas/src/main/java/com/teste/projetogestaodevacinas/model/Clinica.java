package com.teste.projetogestaodevacinas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.List;

@Entity
@Table(name = "clinicas")
public class Clinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String endereco;
    private String telefone;

    @Email
    @Column(unique = true)
    private String email; // Email institucional da clínica


    @OneToMany(mappedBy = "clinica")
    private List<Veterinario> veterinarios;

    // Construtores
    public Clinica() {}

    public Clinica(String nome, String endereco, String telefone, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public List<Veterinario> getVeterinarios() { return veterinarios; }
    public void setVeterinarios(List<Veterinario> veterinarios) { this.veterinarios = veterinarios; }
}
