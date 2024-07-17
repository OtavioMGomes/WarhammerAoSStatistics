package com.warhammer.aos.statistics.warhammer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attack {

  private Integer id;

  private String name;

  private Integer range;

  private Integer quantity;

  private Integer hit;

  private Integer wound;

  private Integer rend;

  private Integer damage;

  private Ability ability;

  public Attack(String name) {
    this.name = name;
  }

}
