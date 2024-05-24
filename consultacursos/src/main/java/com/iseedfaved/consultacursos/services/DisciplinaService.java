package com.iseedfaved.consultacursos.services;


import com.iseedfaved.consultacursos.models.Disciplinas;
import com.iseedfaved.consultacursos.repositorys.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;


    public List<Disciplinas> findAllDiscplinas(){
        return this.disciplinaRepository.findAll();
    }

    public Disciplinas findByIdDisciplinas(Long id){
        Optional<Disciplinas> disciplinas = this.disciplinaRepository.findById(id);
        return disciplinas.orElseThrow(() -> new RuntimeException("Disciplina não encontrada pelo Id: " + id));
    }


    public List<Disciplinas> findByName(String name){
        return this.disciplinaRepository.findByName(name);
    }

    public List<Disciplinas> findIdIesde(){
        return this.disciplinaRepository.findIdIesde();
    }

    public List<Disciplinas> findNotIdIesde(){
        return this.disciplinaRepository.findNotIdIesde();
    }

    public List<Disciplinas> findByCargaHoraria(Double cargaHoraria){
        return this.disciplinaRepository.findByCargaHoraria(cargaHoraria);
    }

    public Disciplinas createOrUpdate(Disciplinas disciplinas){
        if(disciplinas.getId() != null){
            Disciplinas newDisciplinas = findByIdDisciplinas(disciplinas.getId());
            newDisciplinas.setNome(disciplinas.getNome());
            newDisciplinas.setCargaHoraria(disciplinas.getCargaHoraria());
            newDisciplinas.setIdIesde(disciplinas.getIdIesde());
            newDisciplinas.setAtivo(disciplinas.getAtivo());

            this.disciplinaRepository.save(newDisciplinas);
            return newDisciplinas;
        }
        this.disciplinaRepository.save(disciplinas);
        return disciplinas;
    }

    public void delete(Long id){
        this.disciplinaRepository.deleteById(id);
    }
}
