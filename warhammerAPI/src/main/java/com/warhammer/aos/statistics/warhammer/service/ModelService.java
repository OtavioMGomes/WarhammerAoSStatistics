package com.warhammer.aos.statistics.warhammer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.warhammer.aos.statistics.warhammer.model.Model;
import com.warhammer.aos.statistics.warhammer.repository.ModelRepository;

@Service
public class ModelService {

  @Autowired
  ModelRepository repository;

  public Page<Model> listAll(Pageable pageable){
      return repository.findAll(pageable);
  }

  public Optional<Model> getById(Integer id){
      return repository.findById(id);
  }

  public Optional<Model> findByName(String name){
    return repository.findByName(name);
}

  public void save(Model model){
      repository.save(model);
  }


  
}
