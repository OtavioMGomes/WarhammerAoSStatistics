package com.warhammer.aos.statistics.warhammer.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.warhammer.aos.statistics.warhammer.utility.DamageList;
import com.warhammer.aos.statistics.warhammer.utility.DiceRoll;
import com.warhammer.aos.statistics.warhammer.utility.StatisticConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="tb_attack")
@SequenceGenerator(name="attack", sequenceName="sq_attack", allocationSize=1)
public class Attack {

  @Id
  @Column(name="id_attack")
  @GeneratedValue(generator="attack", strategy = GenerationType.SEQUENCE)
  private Integer id;

  @NotBlank
  @Column(name="nm_attack")
  private String name;

  @Column(name="bl_is_shooting")
  private Boolean isShooting;

  @Column(name="vl_range")
  private String range;

  @NotBlank
  @Column(name="vl_attack_quantity")
  private String quantity;

  @NotBlank
  @Column(name="vl_hit")
  private String hit;

  @Column(name="vl_wound")
  private String wound;

  @Column(name="vl_rend")
  private String rend;

  @Column(name="vl_damage")
  private String damage;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name="id_model")
  private Model model;

  public void addModel(Model model){
    model.addToList(this);
  }

  @JsonIgnore
  public Double getAvgDamage(){

    Double dmg = null;

    dmg = Double.valueOf(quantity)
          * DiceRoll.getRollProbability(hit)
          * DiceRoll.getRollProbability(wound)
          * Double.valueOf(damage)
    ;

    return dmg;
  }

  public Double getAvgDamage(String save, String ward){

    Double dmg = null;
    Double saveAdj = StatisticConverter.convert(save);
    Double rendAdj = StatisticConverter.convert(this.rend);
    Double dmgNotSaved = (1 - DiceRoll.getRollProbability(saveAdj - rendAdj));
    Double dmgNotWarded = (1 - DiceRoll.getRollProbability(ward));

    dmg = this.getAvgDamage()
          * dmgNotSaved
          * dmgNotWarded
    ;

    return dmg;
  }

  public Double getAvgDamage(Unit unit){

    Double dmg = null;
    String save = unit.getModel().getStatisticByName("save");
    String ward = unit.getModel().getStatisticByName("ward");

    dmg = this.getAvgDamage(save, ward);

    return dmg;
  }

  @JsonIgnore
  public Map<String, Double> getDamageBySave(){

    Map<String, Double> map = DamageList.getMap();
    Double dmg;

    for (String key : map.keySet()) {
      dmg = this.getAvgDamage();
      map.put(key, dmg * (1 - DiceRoll.getRollProbability(key)));
    }

    return map;
  }

}
