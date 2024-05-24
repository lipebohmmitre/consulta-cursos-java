package com.iseedfaved.consultacursos.services;


import com.iseedfaved.consultacursos.models.Categoria;
import com.iseedfaved.consultacursos.repositorys.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    public List<Categoria> findAll(){
        Iterable<Categoria> categoriasIterable = this.categoriaRepository.findAll();
        List<Categoria> categorias = new ArrayList<>();

        for(Categoria cat : categoriasIterable)
            categorias.add(cat);

        return categorias;
    }

    public Categoria findById(Long id){
        Optional<Categoria> categoria = this.categoriaRepository.findById(id);

        return categoria.orElseThrow(() -> new RuntimeException("Categoria não encontrada pelo Id: " + id));
    }

    public List<Categoria> findByName(String name){
        return this.categoriaRepository.findByName(name);
    }

    @Transactional
    public Categoria createOrUpdate(Categoria cat){
        if(cat.getId() != null){
            Categoria newCategoria = findById(cat.getId());
            newCategoria.setNome(cat.getNome());

            this.categoriaRepository.save(newCategoria);

            return newCategoria;
        }
        this.categoriaRepository.save(cat);
        return cat;
    }

    public void delete(Long id){
        this.categoriaRepository.deleteById(id);
    }
}
