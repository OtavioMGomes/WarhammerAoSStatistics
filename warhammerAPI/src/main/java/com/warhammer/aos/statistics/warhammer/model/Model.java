package com.warhammer.aos.statistics.warhammer.model;

import java.util.List;

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

  public String getStatistic(String name){

    String adjName = name.toLowerCase();
    String value = null;

    for(Statistic s: statistics){

      if(s.getName().toLowerCase().equals(adjName)){
        value = s.getValue();
      }

    }

    return value;
    
  }

}
