package com.warhammer.aos.statistics.warhammer.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Model {

  private Integer id;

  private String name;

  private List<Statistic> statistics;

  private List<Attack> attacks;

  private List<SpecialAbility> specialAbilities;

  private List<String> keywords;

  public Model(String name) {
    this.name = name;
  }

  public Integer getStatistic(String name){

    String adjName = name.toLowerCase();
    Integer value = 0;

    for(Statistic s: statistics){

      if(s.getName().toLowerCase().equals(adjName)){
        value = s.getValue();
      }

    }

    return value;
  }

}
