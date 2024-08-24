package com.warhammer.aos.statistics.warhammer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name="tb_unit")
@SequenceGenerator(name="unit", sequenceName="sq_unit", allocationSize=1)
public class Unit {

  @Id
  @Column(name="id_unit")
  @GeneratedValue(generator="unit", strategy = GenerationType.SEQUENCE)
  private Integer id;

  @NotBlank
  @Column(name="vl_quantity")
  private Integer quantity;

  @NotBlank
  @Column(name="bl_is_reinforced")
  private Boolean isReinforced;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name="id_model")
  private Model model;

  public void addModel(Model model){
    model.addToList(this);
  }
  
}
