package com.warhammer.aos.statistics.warhammer.utility;

import java.util.List;

import com.warhammer.aos.statistics.warhammer.model.Round;
import com.warhammer.aos.statistics.warhammer.model.Unit;

public class Battle {

  private List<Round> rounds;

  public Battle(Unit attacker, Unit defender) {
    
    Round round = new Round();

    round.setAttacker(attacker);
    round.setDefender(defender);

    rounds.add(round);

  }

  public void setNextRoundAttacker(){

    Round round = rounds.get(0);
    Round nextRound = new Round();


  }
  
}
