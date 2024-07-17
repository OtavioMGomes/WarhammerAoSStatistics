package com.warhammer.aos.statistics.warhammer.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecialAbility {

  private Integer id;

  private String name;

  private SpecialAbilityType specialAbilityType;

  private String condition;

  private String effect;

  private List<String> keywords;

}
