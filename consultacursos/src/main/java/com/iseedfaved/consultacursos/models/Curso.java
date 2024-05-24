package com.iseedfaved.consultacursos.models;


import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 255)
    private String nome;


    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private AreaAtuacao areaAtuacao;


    @ManyToMany
    @JoinTable(name = "cursos_disciplinas",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "disciplina_id")
    )
    private List<Disciplinas> disciplinas;

    public Curso(){

    }

    public Curso(String nome, Categoria categoria, AreaAtuacao areaAtuacao) {
        this.nome = nome;
        this.categoria = categoria;
        this.areaAtuacao = areaAtuacao;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public AreaAtuacao getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(AreaAtuacao areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public List<Disciplinas> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplinas> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(id, curso.id) && Objects.equals(nome, curso.nome) && Objects.equals(categoria, curso.categoria) && Objects.equals(areaAtuacao, curso.areaAtuacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, categoria, areaAtuacao);
    }
}
