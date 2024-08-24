package com.warhammer.aos.statistics.warhammer.utility;

public class DiceRoll {

  public static Double getRollProbability(Integer value){

    Double rollProbability;
    
    if(value > 6){

      rollProbability = 0.0;

    }else if(value <= 0){

      rollProbability = 1.0;
      
    }else{

      rollProbability = (double) ((6 - (value -1))/6);

    };

    return rollProbability;
  }

  public static Double getRollProbability(String value){

    Double rollProbability;

    if(value.equals(null)){

      rollProbability = 0.0;
      return rollProbability;

    }else{
      try {

        value = value.replace("+", "");

        Integer valueAdj = Integer.valueOf(value);
        
        if(valueAdj > 6.0){
  
          rollProbability = 0.0;
    
        }else if(valueAdj <= 0.0){
    
          rollProbability = 1.0;
          
        }else{
    
          rollProbability = (double) ((6 - (valueAdj - 1)))/6;
    
        };
  
      } catch (Exception e) {
  
        rollProbability = null;
  
      } 
      
      return rollProbability;
    }
    
  }
  
}
