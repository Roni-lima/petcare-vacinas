package com.teste.projetogestaodevacinas.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "vacinas", uniqueConstraints = @UniqueConstraint(columnNames = "nome"))
public class Vacina {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Column(nullable=false, length=100)
    private String nome;

    @Column(length=100)
    private String fabricante;

    @Column(length=100)
    private String nºDosagem;

    public Vacina(){}
    public Vacina(String nome, String fabricante, String nºDosagem){this.nome = nome; this.fabricante = fabricante; this.nºDosagem = nºDosagem;}

    public Long getId(){return id;}
    public String getNome(){return nome;}
    public void setNome(String nome){this.nome = nome;}
    public String getFabricante(){return fabricante;}
    public void setFabricante(String fabricante){this.fabricante = fabricante;}
    public String getNºDosagem(){return nºDosagem;}
    public void setNºDosagem(String nºDosagem){this.nºDosagem = nºDosagem;}
}
