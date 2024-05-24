package com.iseedfaved.consultacursos.repositorys;


import com.iseedfaved.consultacursos.models.AreaAtuacao;
import com.iseedfaved.consultacursos.models.Categoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaAtuacaoRepository extends CrudRepository<AreaAtuacao, Long> {

    @Query(value = "SELECT a FROM AreaAtuacao a WHERE a.nome LIKE %:name%")
    List<AreaAtuacao> findByName(@Param("name") String name);

}
