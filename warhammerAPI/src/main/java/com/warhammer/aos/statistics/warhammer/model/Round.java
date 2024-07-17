package com.warhammer.aos.statistics.warhammer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Round {

  private Unit defender;

  private Unit attacker;
  
}
