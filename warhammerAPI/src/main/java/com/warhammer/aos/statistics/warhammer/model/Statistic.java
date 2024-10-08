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
@Table(name="tb_model_statistic")
@SequenceGenerator(name="stat", sequenceName="sq_model_statistic", allocationSize=1)
public class Statistic {

  @Id
  @Column(name="id_model_statistic")
  @GeneratedValue(generator="stat", strategy = GenerationType.SEQUENCE)
  private Integer id;

  @NotBlank
  @Column(name="nm_statistic")
  private String name;

  @NotBlank
  @Column(name="vl_statistic")
  private String value;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name="id_model")
  private Model model;

  public Statistic(@NotBlank String name) {
    this.name = name;
  }

  public Statistic(@NotBlank String name, @NotBlank String value) {
    this.name = name;
    this.value = value;
  }

  public void addModel(Model model){
    model.addToList(this);
  }

}
