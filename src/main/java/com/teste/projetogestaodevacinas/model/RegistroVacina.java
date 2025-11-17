package com.teste.projetogestaodevacinas.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "registros_vacina")
public class RegistroVacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_aplicacao", nullable = false)
    private LocalDate dataAplicacao;

    //Pet relacionado
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;

    //Vacina aplicada
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vacina_id", nullable = false)
    private Vacina vacina;

    //Veterinario responsável pela aplicação
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veterinario_id") // pode ser nulo caso o registro antigo não tenha vínculo
    private Veterinario veterinario;

    //Dose (opcional)
    @Column(length = 20)
    private String dose;

    //Observações (opcional)
    @Column(length = 255)
    private String observacao;

    public RegistroVacina() {}

    public RegistroVacina(Pet pet, Vacina vacina, Veterinario veterinario, LocalDate dataAplicacao, String dose, String observacao) {
        this.pet = pet;
        this.vacina = vacina;
        this.veterinario = veterinario;
        this.dataAplicacao = dataAplicacao;
        this.dose = dose;
        this.observacao = observacao;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public LocalDate getDataAplicacao() { return dataAplicacao; }
    public void setDataAplicacao(LocalDate dataAplicacao) { this.dataAplicacao = dataAplicacao; }

    public Pet getPet() { return pet; }
    public void setPet(Pet pet) { this.pet = pet; }

    public Vacina getVacina() { return vacina; }
    public void setVacina(Vacina vacina) { this.vacina = vacina; }

    public Veterinario getVeterinario() { return veterinario; }
    public void setVeterinario(Veterinario veterinario) { this.veterinario = veterinario; }

    public String getDose() { return dose; }
    public void setDose(String dose) { this.dose = dose; }

    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }
}
