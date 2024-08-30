package com.warhammer.aos.statistics.warhammer.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.warhammer.aos.statistics.warhammer.utility.DamageList;
import com.warhammer.aos.statistics.warhammer.utility.DiceRoll;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_model")
@SequenceGenerator(name="model", sequenceName="sq_model", allocationSize=1)
public class Model {

  @Id
  @Column(name="id_model")
  @GeneratedValue(generator="model", strategy = GenerationType.SEQUENCE)
  private Integer id;
  
  @NotBlank
  @Column(name="nm_model")
  private String name;

  @OneToMany(fetch = FetchType.EAGER, mappedBy="model", cascade = CascadeType.ALL)
  private List<Statistic> statistics;

  @OneToMany(fetch = FetchType.EAGER, mappedBy="model", cascade = CascadeType.ALL)
  private List<Attack> attacks;

  @OneToMany(fetch = FetchType.EAGER, mappedBy="model", cascade = CascadeType.ALL)
  private List<Keyword> keywords;

  @OneToMany(fetch = FetchType.EAGER, mappedBy="model", cascade = CascadeType.ALL)
  private List<Unit> units;

  public Model(String name) {
    this.name = name;
  }

  public void addToList(Keyword keyword){
    keyword.setModel(this);
    this.keywords.add(keyword);
  }

  public void addToList(Statistic statistic){
    statistic.setModel(this);
    this.statistics.add(statistic);
  }

  public void addToList(Attack attack){
    attack.setModel(this);
    this.attacks.add(attack);
  }

  public void addToList(Unit unit){
    unit.setModel(this);
    this.units.add(unit);
  }

  public String getStatisticByName(String name){

    String adjName = name.toLowerCase();
    String value = null;

    for(Statistic s: statistics){

      if(s.getName().toLowerCase().equals(adjName)){
        value = s.getValue();
      }

    }

    return value;
    
  }

  @JsonIgnore
  public Double getAvgDamage(){

    Double dmg = 0.0;

    for(Attack a: this.attacks){
      dmg += a.getAvgDamage();
    }

    return dmg;
  }

  public Double getAvgDamage(String save, String ward){

    Double dmg = 0.0;

    for(Attack a: this.attacks){
      dmg += a.getAvgDamage(save, ward);
    }

    return dmg;
  }

  public Double getAvgDamage(Unit unit){

    Double dmg = 0.0;

    for(Attack a: this.attacks){
      dmg += a.getAvgDamage(unit);
    }

    return dmg;
  }

  @JsonIgnore
  public Map<String, Double> getDamageBySave(){

    Map<String, Double> map = DamageList.getMap();
    Double dmg;

    for(Attack a: this.attacks){
      for (String key : map.keySet()) {
        dmg = a.getAvgDamage() * (1 - DiceRoll.getRollProbability(key));
        Double dmgComputed = map.get(key);
        if(dmgComputed == null){
          dmgComputed = 0.0;
        }
        map.put(key, dmgComputed + dmg);
      }
    }
    
    return map;
  }

  @JsonIgnore
  public Double getAvgSave(){

    String saveStat = this.getStatisticByName("save");
    String wardStat = this.getStatisticByName("ward");
    
    Double save = DiceRoll.getRollProbability(saveStat);
    Double ward = DiceRoll.getRollProbability(wardStat);

    Double avgSave = save + (ward * (1 - save));
    
    return avgSave;
  }

}
