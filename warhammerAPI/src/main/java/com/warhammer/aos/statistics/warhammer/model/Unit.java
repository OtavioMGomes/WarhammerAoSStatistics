package com.warhammer.aos.statistics.warhammer.model;

import java.util.List;

import com.warhammer.aos.statistics.warhammer.utility.DiceRoll;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Unit {
  
  private Integer id;

  private String name;

  private Integer quantity;
  
  private Boolean isReinforced;
  
  private Model model;

  private List<Attack> modifiers;

  public Unit(String name) {
    this.name = name;
  }

  public Double averageDamage(){

    List<Attack> attacks = model.getAttacks();
    Double averageDamage = 0.0;

    for(Attack atk: attacks){

      if(atk.getRange() != null) {
        Double qtd = (double) atk.getQuantity();
        Integer hit = atk.getHit();
        Integer wound = atk.getWound();
        Double dmg = (double) atk.getDamage();
        
        averageDamage += qtd * DiceRoll.getRollProbability(hit) * DiceRoll.getRollProbability(wound) * dmg;        
      } 

    };

    return averageDamage;

  };

  public Double averageDamageGiven(){

    return this.averageDamage() * this.getQuantity();

  }

  public Double averageDamageGiven(Integer quantityLeft){

    Double adjQuantityLeft = (double) quantityLeft;

    return this.averageDamage() * adjQuantityLeft;

  }

  public Double averageSaveProbability(){

    Double averageSave = 0.0;
    Double health = DiceRoll.getRollProbability(model.getStatistic("health"));
    Double ward = DiceRoll.getRollProbability(model.getStatistic("ward"));

    averageSave = health * ward;

    return averageSave;

  }

  public Double averageSaveProbability(Integer rend){

    Double averageSave = 0.0;
    Double health = DiceRoll.getRollProbability(model.getStatistic("health") + rend);
    Double ward = DiceRoll.getRollProbability(model.getStatistic("ward"));

    averageSave = health + (ward * (1 - health));

    return averageSave;

  }

  public Double averageSave(Integer damage){

    Double adjDamage = (double) damage;

    return this.averageSaveProbability() * adjDamage;

  }

  public Double averageSave(Integer rend, Integer damage){

    Double adjDamage = (double) damage;

    return this.averageSaveProbability(rend) * adjDamage;

  }

  public Double averageDamageTaken(Integer damage){

    Double adjDamage = (double) damage;

    return adjDamage - this.averageSave(damage);

  }

  public Double averageDamageTaken(Integer rend, Integer damage){

    Double adjDamage = (double) damage;

    return adjDamage - this.averageSave(rend, damage);

  }

}
