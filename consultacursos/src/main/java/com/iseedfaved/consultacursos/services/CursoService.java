package com.iseedfaved.consultacursos.services;


import com.iseedfaved.consultacursos.models.Curso;
import com.iseedfaved.consultacursos.models.Disciplinas;
import com.iseedfaved.consultacursos.repositorys.CursoRepository;
import com.iseedfaved.consultacursos.repositorys.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private DisciplinaRepository disciplinaRepository;



    public List<Curso> findAll(){
        return this.cursoRepository.findAll();
    }

    public Curso findById(Long id){
        Optional<Curso> curso = this.cursoRepository.findById(id);

        return curso.orElseThrow(() -> new RuntimeException("Curso não encontrado pelo Id: " + id));
    }

    public List<Curso> findByName(String name){
        return this.cursoRepository.findByName(name);
    }


    public List<Curso> findCursosByAreaAtuacaoId(Long areaAtuacaoId){
        return this.cursoRepository.findCursosByAreaAtuacaoId(areaAtuacaoId);
    }

    public List<Curso> findCursosByCategoriaId(Long categoriaId){
        return this.cursoRepository.findCursosByCategoriaId(categoriaId);
    }

    //Arrumar
    public List<Disciplinas> findCursoAndDisciplinas(Long idCurso){
        Curso curso = findById(idCurso);
        return curso.getDisciplinas();
    }

    public Curso createOrUpdate(Curso curso){
        if(curso.getId() != null){
            Curso newCurso = findById(curso.getId());
            newCurso.setNome(curso.getNome());
            newCurso.setCategoria(curso.getCategoria());
            newCurso.setAreaAtuacao(curso.getAreaAtuacao());

            this.cursoRepository.save(newCurso);
            return newCurso;
        }
        this.cursoRepository.save(curso);
        return curso;
    }


    public void delete(Long id){
        this.cursoRepository.deleteById(id);
    }



    public Curso addDisciplina(Long idCurso, List<Long> idDisciplinas){
        Curso curso = findById(idCurso);
        List<Disciplinas> disciplinasList = new ArrayList<>();

        for(Long id : idDisciplinas){
            Optional<Disciplinas> disciplinas = this.disciplinaRepository.findById(id);
            disciplinasList.add(disciplinas.orElseThrow(() -> new RuntimeException("Disciplina não encontrada no Id")));
        }


        curso.getDisciplinas().addAll(disciplinasList);
        this.cursoRepository.save(curso);
        return curso;
    }
}
