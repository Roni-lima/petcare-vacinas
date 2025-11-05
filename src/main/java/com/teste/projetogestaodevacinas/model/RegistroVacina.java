package com.teste.projetogestaodevacinas.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "registros_vacina")
public class RegistroVacina {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_aplicacao", nullable = false)
    private LocalDate dataAplicacao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="pet_id", nullable=false)
    private Pet pet;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="vacina_id", nullable=false)
    private Vacina vacina;

    public RegistroVacina(){}

    public RegistroVacina(Pet pet, Vacina vacina, LocalDate dataAplicacao){
        this.pet = pet; this.vacina = vacina; this.dataAplicacao = dataAplicacao;
    }

    public Long getId(){return id;}
    public LocalDate getDataAplicacao(){return dataAplicacao;}
    public void setDataAplicacao(LocalDate d){this.dataAplicacao = d;}
    public Pet getPet(){return pet;}
    public void setPet(Pet p){this.pet = p;}
    public Vacina getVacina(){return vacina;}
    public void setVacina(Vacina v){this.vacina = v;}
}
