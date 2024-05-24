package com.iseedfaved.consultacursos.controllers;


import com.iseedfaved.consultacursos.models.Curso;
import com.iseedfaved.consultacursos.models.Disciplinas;
import com.iseedfaved.consultacursos.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> findAll(){
        List<Curso> cursos = this.cursoService.findAll();

        return ResponseEntity.ok().body(cursos);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Curso> findById(@PathVariable Long id){
        Curso curso = this.cursoService.findById(id);

        return ResponseEntity.ok().body(curso);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Curso>> findByName(@PathVariable String name){
        List<Curso> cursos = this.cursoService.findByName(name);

        return ResponseEntity.ok().body(cursos);
    }

    @GetMapping("/areaatuacao/{id}")
    public ResponseEntity<List<Curso>> findByAreaAtuacaoId(@PathVariable Long id){
        List<Curso> cursos = this.cursoService.findCursosByAreaAtuacaoId(id);

        return ResponseEntity.ok().body(cursos);
    }


    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<Curso>> findByCategoriaId(@PathVariable Long id){
        List<Curso> cursos = this.cursoService.findCursosByCategoriaId(id);

        return ResponseEntity.ok().body(cursos);
    }

    // Arrumar
    @GetMapping("/cursoanddisciplina/{id}")
    public ResponseEntity<List<Disciplinas>> findCursoAndDisciplinas(@PathVariable Long id){
        List<Disciplinas> disciplinas = this.cursoService.findCursoAndDisciplinas(id);

        return ResponseEntity.ok().body(disciplinas);
    }

    @PostMapping
    public ResponseEntity<Curso> create(@RequestBody Curso curso){
        curso.setId(null);
        this.cursoService.createOrUpdate(curso);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id/{id}").buildAndExpand(curso.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PostMapping("/{idCurso}")
    public ResponseEntity<Curso> addDisciplinas(@PathVariable Long idCurso, @RequestBody List<Long> idDisciplinas){
        Curso curso = this.cursoService.addDisciplina(idCurso, idDisciplinas);

        return ResponseEntity.ok().body(curso);
    }


    @PutMapping
    public ResponseEntity<Curso> update(@RequestBody Curso curso){
        Curso cursoResponse = this.cursoService.createOrUpdate(curso);

        return ResponseEntity.ok().body(cursoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.cursoService.delete(id);

        return ResponseEntity.ok().build();
    }
}
