package com.warhammer.aos.statistics.warhammer.test;

import com.warhammer.aos.statistics.warhammer.model.Attack;

public class Print {

  public static void main(String[] args) {

    Attack atk = new Attack(
      1, 
      "Teste",
      false,
      "3",
      "1",
      "4+",
      "4+",
      "-1",
      "1",
      null);

    System.out.println(atk.getAvgDamage("6+", "6+"));

  }

}
