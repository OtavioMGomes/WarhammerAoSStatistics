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
@Table(name="tb_keyword")
@SequenceGenerator(name="keyword", sequenceName="sq_keyword", allocationSize=1)
public class Keyword {

  @Id
  @Column(name="id_keyword")
  @GeneratedValue(generator="keyword", strategy = GenerationType.SEQUENCE)
  private Integer id;
  
  @NotBlank
  @Column(name="ds_keyword")
  private String name;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name="id_model")
  private Model model;

  public Keyword(@NotBlank String name) {
    this.name = name;
  }

  public Keyword(@NotBlank String name, Model model) {
    this.name = name;
    this.model = model;
  }

  public void addModel(Model model){
    model.addToList(this);
  }

}
