package com.iseedfaved.consultacursos.repositorys;

import com.iseedfaved.consultacursos.models.Categoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

    @Query(value = "SELECT c FROM Categoria c WHERE c.nome LIKE %:name%")
    List<Categoria> findByName(@Param("name") String name);

}
