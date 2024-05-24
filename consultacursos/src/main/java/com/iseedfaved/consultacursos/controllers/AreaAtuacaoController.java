package com.iseedfaved.consultacursos.controllers;


import com.iseedfaved.consultacursos.models.AreaAtuacao;
import com.iseedfaved.consultacursos.services.AreaAtuacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/areaatuacao")
public class AreaAtuacaoController {


    @Autowired
    private AreaAtuacaoService areaAtuacaoService;



    @GetMapping()
    public ResponseEntity<List<AreaAtuacao>> findAll(){
        List<AreaAtuacao> areaAtuacoes = this.areaAtuacaoService.findAll();

        return ResponseEntity.ok().body(areaAtuacoes);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<AreaAtuacao> findById(@PathVariable Long id){
        AreaAtuacao areaAtuacao = this.areaAtuacaoService.findByid(id);

        return ResponseEntity.ok().body(areaAtuacao);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<AreaAtuacao>> findByName(@PathVariable String name){
        List<AreaAtuacao> areaAtuacoes = this.areaAtuacaoService.findByName(name);

        return ResponseEntity.ok().body(areaAtuacoes);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody AreaAtuacao areaAtuacao){
        areaAtuacao.setId(null);
        this.areaAtuacaoService.createOrUpdate(areaAtuacao);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id/{id}").buildAndExpand(areaAtuacao.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<AreaAtuacao> update(@RequestBody AreaAtuacao areaAtuacao){
        AreaAtuacao areaAtuacaoResponse = this.areaAtuacaoService.createOrUpdate(areaAtuacao);

        return ResponseEntity.ok().body(areaAtuacaoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.areaAtuacaoService.delete(id);

        return ResponseEntity.ok().build();
    }
}
