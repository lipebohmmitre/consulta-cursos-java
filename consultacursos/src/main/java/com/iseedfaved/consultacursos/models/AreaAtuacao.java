package com.iseedfaved.consultacursos.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;


@Entity
@Table(name = "tb_areas_atuacoes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class AreaAtuacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 200)
    private String nome;


    @OneToMany(mappedBy = "areaAtuacao")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Curso> cursos;

}
