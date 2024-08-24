package com.warhammer.aos.statistics.warhammer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.warhammer.aos.statistics.warhammer.model.Model;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer>{

  @Query(value="select m from Model m where lower(m.name) = lower(?1)", nativeQuery = false) 
  Optional<Model> findByName(String nome);
  
}
