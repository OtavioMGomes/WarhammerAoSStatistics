package com.warhammer.aos.statistics.warhammer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warhammer.aos.statistics.warhammer.repository.ModelRepository;

@Service
public class ModelService {

  @Autowired
  ModelRepository unitRepository;

    // public Page<Atividade> listAll(Pageable pageable){
    //     return repository.findAll(pageable);
    // }

    // public Optional<Atividade> getById(Integer id){
    //     return repository.findById(id);
    // }

    // public void save(Atividade tipoAtividade){
    //     tipoAtividade.setDtRegistro();
    //     repository.save(tipoAtividade);
    // }
  
}
