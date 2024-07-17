package com.warhammer.aos.statistics.warhammer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecialAbilityType {
  
  private Integer id;

  private String type;

  private String description;

  private Integer timesUsability;

}
