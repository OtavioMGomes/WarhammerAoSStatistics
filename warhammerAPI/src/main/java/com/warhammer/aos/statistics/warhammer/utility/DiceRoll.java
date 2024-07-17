package com.warhammer.aos.statistics.warhammer.utility;

public class DiceRoll {

  public static Double getRollProbability(Integer value){

    Double rollProbability;
    
    if(value > 6){

      rollProbability = 0.0;

    }else if(value == 0){

      rollProbability = 1.0;
      
    }else{

      rollProbability = (double) ((6 - (value -1))/6);

    };

    return rollProbability;
  }
  
}
