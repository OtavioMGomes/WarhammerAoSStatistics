package com.warhammer.aos.statistics.warhammer.utility;

public class StatisticConverter {

  public static Double convert(String value){

    Double convertedValue;

    if(value == null || value.isEmpty()){

      convertedValue = null;

    }else if(!value.toLowerCase().contains("d")){

      value = value.replace("+", "");
      value = value.replace("-", "");

      convertedValue =  Double.valueOf(value);

    }else{
      
      convertedValue = null;
      
    }

    return convertedValue;

  }
  
}
