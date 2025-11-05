package com.teste.projetogestaodevacinas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pets")
public class Pet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Column(nullable=false, length=50)
    private String nome;

    @NotBlank @Column(nullable=false, length=50)
    private String especie;

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

    public Pet(String nome, String especie, Integer idade, Usuario dono){
        this.nome = nome; this.especie = especie; this.idade = idade; this.dono = dono;
    }

    public Long getId(){return id;}
    public String getNome(){return nome;}
    public void setNome(String nome){this.nome = nome;}
    public String getEspecie(){return especie;}
    public void setEspecie(String especie){this.especie = especie;}
    public Integer getIdade(){return idade;}
    public void setIdade(Integer idade){this.idade = idade;}
    public Usuario getDono(){return dono;}
    public void setDono(Usuario dono){this.dono = dono;}
    public List<RegistroVacina> getRegistrosVacina(){return registrosVacina;}
    public List<Agenda> getAgendas(){return agendas;}
}
