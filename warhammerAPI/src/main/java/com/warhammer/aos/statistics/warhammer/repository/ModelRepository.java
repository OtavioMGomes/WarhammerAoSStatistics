package com.warhammer.aos.statistics.warhammer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.warhammer.aos.statistics.warhammer.model.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer>{

  @Query(value="select m from Model m where lower(m.name) like concat('%', lower(?1), '%')", nativeQuery = false) 
  Optional<Model> findByName(String name);
  
}
