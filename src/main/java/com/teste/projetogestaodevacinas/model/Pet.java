package com.teste.projetogestaodevacinas.model;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "pets")
public class Pet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Column(nullable=false, length=50)
    private String nome;

    @NotBlank @Column(nullable=false, length=50)
    private String raca;

    @NotNull @Column(nullable=false)
    private Integer idade;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario dono;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegistroVacina> registrosVacina = new ArrayList<>();

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Agenda> agendas = new ArrayList<>();

    public Pet(){}

    public Pet(String nome, String raca, Integer idade, Usuario dono){
        this.nome = nome; this.raca = raca; this.idade = idade; this.dono = dono;
    }

    public Long getId(){return id;}
    public String getNome(){return nome;}
    public void setNome(String nome){this.nome = nome;}
    public String getraca(){return raca;}
    public void setraca(String raca){this.raca = raca;}
    public Integer getIdade(){return idade;}
    public void setIdade(Integer idade){this.idade = idade;}
    public Usuario getDono(){return dono;}
    public void setDono(Usuario dono){this.dono = dono;}
    public List<RegistroVacina> getRegistrosVacina(){return registrosVacina;}
    public List<Agenda> getAgendas(){return agendas;}
}
