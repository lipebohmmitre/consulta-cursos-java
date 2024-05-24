package com.iseedfaved.consultacursos.models;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_disciplinas")
public class Disciplinas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 255)
    private String nome;

    @Column(name = "carga_horaria", nullable = false)
    private Double cargaHoraria;

    @Column(name = "id_iesde", nullable = false)
    private Integer idIesde;

    @Column(nullable = false)
    private Boolean ativo;


    public Disciplinas(){

    }


    public Disciplinas(String nome, Double cargaHoraria, Integer idIesde, Boolean ativo) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.idIesde = idIesde;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Integer getIdIesde() {
        return idIesde;
    }

    public void setIdIesde(Integer idIesde) {
        this.idIesde = idIesde;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplinas that = (Disciplinas) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(cargaHoraria, that.cargaHoraria) && Objects.equals(idIesde, that.idIesde) && Objects.equals(ativo, that.ativo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cargaHoraria, idIesde, ativo);
    }
}
