package com.teste.projetogestaodevacinas.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "veterinarios")
@PrimaryKeyJoinColumn(name = "usuario_id") // Importante!
public class Veterinario extends Usuario{


    @Column(nullable = false, unique = true)
    private String crmv; // Registro profissional do veterinário

    private String especialidade;

    @ManyToOne
    @JoinColumn(name ="clinica_id")
    private Clinica clinica; //Clínica onde trabalha

    @OneToMany(mappedBy = "veterinario")
    private List<RegistroVacina> registrosFeitos;

    // Construtores
    public Veterinario() {}

    public Veterinario(String nome, String email, String cpf, String telefone, String crmv, String especialidade) {
        super(nome, email, cpf, telefone);
        this.crmv = crmv;
        this.especialidade = especialidade;
    }

     // Getters e Setters
    public String getCrmv() { return crmv; }
    public void setCrmv(String crmv) { this.crmv = crmv; }
    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
    public Clinica getClinica() { return clinica; }
    public void setClinica(Clinica clinica) { this.clinica = clinica; }
    public List<RegistroVacina> getRegistrosFeitos() { return registrosFeitos; }
    public void setRegistrosFeitos(List<RegistroVacina> registrosFeitos) { this.registrosFeitos = registrosFeitos; }
}
