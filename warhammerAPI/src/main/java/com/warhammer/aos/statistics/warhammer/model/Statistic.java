package com.warhammer.aos.statistics.warhammer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Statistic {

  private Integer id;

  private String name;

  private Integer value;

}
