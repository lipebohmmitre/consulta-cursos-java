package com.iseedfaved.consultacursos.repositorys;


import com.iseedfaved.consultacursos.models.Disciplinas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplinas, Long> {

    @Query(value = "SELECT d FROM Disciplinas d WHERE d.nome LIKE %:name%")
    List<Disciplinas> findByName(@Param("name") String name);

    @Query(value = "SELECT d FROM Disciplinas d WHERE d.idIesde > 0")
    List<Disciplinas> findIdIesde();

    @Query(value = "SELECT d FROM Disciplinas d WHERE d.idIesde = 0")
    List<Disciplinas> findNotIdIesde();

    @Query(value = "SELECT d FROM Disciplinas d WHERE d.cargaHoraria = :cargaHoraria")
    List<Disciplinas> findByCargaHoraria(@Param("cargaHoraria") Double cargaHoraria);

}
