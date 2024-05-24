package com.iseedfaved.consultacursos.services;


import com.iseedfaved.consultacursos.models.AreaAtuacao;
import com.iseedfaved.consultacursos.repositorys.AreaAtuacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AreaAtuacaoService {

    @Autowired
    private AreaAtuacaoRepository areaAtuacaoRepository;


    public List<AreaAtuacao> findAll(){
        Iterable<AreaAtuacao> areaAtuacaoIterable = this.areaAtuacaoRepository.findAll();
        List<AreaAtuacao> areaAtuacoes = new ArrayList<>();

        for(AreaAtuacao areaAtu : areaAtuacaoIterable)
            areaAtuacoes.add(areaAtu);

        return areaAtuacoes;
    }

    public AreaAtuacao findByid(Long id){
        Optional<AreaAtuacao> areaAtuacao = this.areaAtuacaoRepository.findById(id);

        return areaAtuacao.orElseThrow(() -> new RuntimeException("Área de Atuação não encontrada com o Id: " + id));
    }

    public List<AreaAtuacao> findByName(String name){
        return this.areaAtuacaoRepository.findByName(name);
    }

    public AreaAtuacao createOrUpdate(AreaAtuacao areaAtuacao){
        if(areaAtuacao.getId() != null){
            AreaAtuacao newAreaAtuacao = findByid(areaAtuacao.getId());
            newAreaAtuacao.setNome(areaAtuacao.getNome());

            this.areaAtuacaoRepository.save(newAreaAtuacao);
            return newAreaAtuacao;
        }
        this.areaAtuacaoRepository.save(areaAtuacao);

        return areaAtuacao;
    }

    public void delete(Long id){
        this.areaAtuacaoRepository.deleteById(id);
    }
}
