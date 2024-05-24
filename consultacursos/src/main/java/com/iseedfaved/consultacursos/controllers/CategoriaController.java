package com.iseedfaved.consultacursos.controllers;

import com.iseedfaved.consultacursos.models.Categoria;
import com.iseedfaved.consultacursos.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


    @GetMapping()
    public ResponseEntity<List<Categoria>> findAll(){
        List<Categoria> categorias = this.categoriaService.findAll();

        return ResponseEntity.ok().body(categorias);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id){
        Categoria categoria = this.categoriaService.findById(id);

        return ResponseEntity.ok().body(categoria);
    }


    @GetMapping("/nome/{name}")
    public ResponseEntity<List<Categoria>> findByName(@PathVariable String name){
        List<Categoria> categorias = this.categoriaService.findByName(name);

        return ResponseEntity.ok().body(categorias);
    }


    @PostMapping()
    public ResponseEntity<Void> create(@RequestBody Categoria categoria){
        categoria.setId(null);
        this.categoriaService.createOrUpdate(categoria);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id/{id}").buildAndExpand(categoria.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }


    @PutMapping()
    public ResponseEntity<Categoria> update(@RequestBody Categoria categoria){
        Categoria categoriaResult = this.categoriaService.createOrUpdate(categoria);

        return ResponseEntity.ok(categoriaResult);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.categoriaService.delete(id);

        return  ResponseEntity.ok().build();
    }

}
