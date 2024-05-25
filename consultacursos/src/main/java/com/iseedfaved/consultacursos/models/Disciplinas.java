package com.iseedfaved.consultacursos.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "tb_disciplinas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
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
}
