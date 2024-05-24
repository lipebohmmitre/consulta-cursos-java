package com.iseedfaved.consultacursos.controllers;


import com.iseedfaved.consultacursos.models.Disciplinas;
import com.iseedfaved.consultacursos.services.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;


    @GetMapping
    public ResponseEntity<List<Disciplinas>> findAll(){
        List<Disciplinas> disciplinas = this.disciplinaService.findAllDiscplinas();

        return ResponseEntity.ok().body(disciplinas);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Disciplinas> findById(@PathVariable Long id){
        Disciplinas disciplinas = this.disciplinaService.findByIdDisciplinas(id);

        return ResponseEntity.ok().body(disciplinas);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Disciplinas>> findByName(@PathVariable String name){
        List<Disciplinas> disciplinas = this.disciplinaService.findByName(name);

        return ResponseEntity.ok().body(disciplinas);
    }

    @GetMapping("/iesde")
    public ResponseEntity<List<Disciplinas>> findByIdIesde(){
        List<Disciplinas> disciplinas = this.disciplinaService.findIdIesde();

        return ResponseEntity.ok().body(disciplinas);
    }

    @GetMapping("/notiesde")
    public ResponseEntity<List<Disciplinas>> findNotByIdIesde(){
        List<Disciplinas> disciplinas = this.disciplinaService.findNotIdIesde();

        return ResponseEntity.ok().body(disciplinas);
    }

    @GetMapping("/cargahoraria/{cargaHoraria}")
    public ResponseEntity<List<Disciplinas>> findByCargaHoraria(@PathVariable Double cargaHoraria){
        List<Disciplinas> disciplinas = this.disciplinaService.findByCargaHoraria(cargaHoraria);

        return ResponseEntity.ok().body(disciplinas);
    }


    @PostMapping
    public ResponseEntity<Disciplinas> create(@RequestBody Disciplinas disciplinas){
        disciplinas.setId(null);
        Disciplinas disciplinaResponse = this.disciplinaService.createOrUpdate(disciplinas);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id/{id}").buildAndExpand(disciplinas.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<Disciplinas> update(@RequestBody Disciplinas disciplinas){
        Disciplinas disciplinaResponse = this.disciplinaService.createOrUpdate(disciplinas);

        return ResponseEntity.ok().body(disciplinaResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.disciplinaService.delete(id);

        return ResponseEntity.ok().build();
    }
}
