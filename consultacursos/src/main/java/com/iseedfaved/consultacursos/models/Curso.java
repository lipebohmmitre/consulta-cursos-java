package com.iseedfaved.consultacursos.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_cursos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
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

}
