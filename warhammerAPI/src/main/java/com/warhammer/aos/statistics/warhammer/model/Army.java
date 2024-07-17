package com.warhammer.aos.statistics.warhammer.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Army {

  private Integer id;

  private String name;
  
  private Integer value;

  private SpellLore spellLore;
  
  private List<Battalion> battalions;

}
