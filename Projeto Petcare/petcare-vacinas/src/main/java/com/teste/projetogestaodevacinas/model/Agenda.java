package com.teste.projetogestaodevacinas.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "agenda")
public class Agenda {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_agendada", nullable = false)
    private LocalDate dataAgendada;

    @Column(nullable = false, length = 50)
    private String tipo;

    @Column(nullable = false, length = 30)
    private String status;

    @Column(length = 255)
    private String observacao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="pet_id", nullable=false)
    private Pet pet;

    public Agenda(){}

    public Agenda(Pet pet, LocalDate dataAgendada, String tipo, String status, String observacao){
        this.pet = pet; this.dataAgendada = dataAgendada; this.tipo = tipo; this.status = status; this.observacao = observacao;
    }

    public Long getId(){return id;}
    public LocalDate getDataAgendada(){return dataAgendada;}
    public void setDataAgendada(LocalDate d){this.dataAgendada = d;}
    public String getTipo(){return tipo;}
    public void setTipo(String tipo){this.tipo = tipo;}
    public String getStatus(){return status;}
    public void setStatus(String status){this.status = status;}
    public String getObservacao(){return observacao;}
    public void setObservacao(String observacao){this.observacao = observacao;}
    public Pet getPet(){return pet;}
    public void setPet(Pet p){this.pet = p;}
}
