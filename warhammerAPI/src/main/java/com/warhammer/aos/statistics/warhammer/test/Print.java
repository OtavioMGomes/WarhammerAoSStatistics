package com.warhammer.aos.statistics.warhammer.test;

import java.util.Map;

import com.warhammer.aos.statistics.warhammer.model.Attack;
import com.warhammer.aos.statistics.warhammer.utility.DamageList;
import com.warhammer.aos.statistics.warhammer.utility.DiceRoll;

public class Print {

  public static void main(String[] args) {

    Attack atk = new Attack(1, "Teste", false, "3", "1", "2+", "4+", "-1", "1", null);

    System.out.println(atk.getDamageBySave());

  }

}
