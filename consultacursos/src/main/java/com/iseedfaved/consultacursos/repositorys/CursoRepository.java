package com.iseedfaved.consultacursos.repositorys;


import com.iseedfaved.consultacursos.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Query(value = "SELECT c FROM Curso c WHERE c.nome LIKE %:name%")
    public List<Curso> findByName(@Param("name") String name);

    @Query(value = "SELECT c FROM Curso c WHERE c.areaAtuacao.id = :areaAtuacaoId")
    List<Curso> findCursosByAreaAtuacaoId(@Param("areaAtuacaoId") Long areaAtuacaoId);

    @Query(value = "SELECT c FROM Curso c WHERE c.categoria.id = :categoriaId")
    List<Curso> findCursosByCategoriaId(@Param("categoriaId") Long categoriaId);

}
