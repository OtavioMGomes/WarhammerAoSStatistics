SET check_function_bodies = false;

create sequence sq_model;

create sequence sq_model_statistic;

create sequence sq_attack;

create sequence sq_unit;

CREATE TABLE tb_model(
id_model integer NOT NULL, nm_model text,
  CONSTRAINT pk_model_id PRIMARY KEY(id_model)
);

CREATE TABLE tb_model_statistic(
  id_model_statistic integer NOT NULL,
  id_model integer NOT NULL,
  nm_statistics text,
  vl_statistic integer,
  CONSTRAINT pk_model_statistic_id PRIMARY KEY(id_model_statistic)
);

CREATE TABLE tb_keyword(
id_keyword integer NOT NULL, nm_keyword text,
  CONSTRAINT pk_keyword_id PRIMARY KEY(id_keyword)
);

CREATE TABLE tb_attack(
  id_attack integer NOT NULL,
  id_model integer NOT NULL,
  nm_attack text,
  vl_range integer,
  vl_attack_quantity integer,
  vl_hit integer,
  vl_wound integer,
  vl_rend integer,
  vl_damage integer,
  CONSTRAINT pk_attack PRIMARY KEY(id_attack)
);

CREATE TABLE tb_ability(
  id_ability integer NOT NULL,
  id_attack integer NOT NULL,
  nm_ability text,
  vl_abiity integer,
  CONSTRAINT pk_ability PRIMARY KEY(id_ability)
);

CREATE TABLE tb_special_ability(
  id_special_ability integer NOT NULL,
  id_model integer NOT NULL,
  id_special_ability_type integer NOT NULL,
  nm_special_ability text,
  ds_condition text,
  ds_effect text,
  CONSTRAINT pk_special_ability_id PRIMARY KEY(id_special_ability)
);

CREATE TABLE tb_special_ability_type(
  id_special_ability_type integer NOT NULL,
  nm_special_ability_type text,
  ds_special_ability_type text,
  vl__special_ability_type_times_usability integer,
  CONSTRAINT pk_special_ability_type_id PRIMARY KEY(id_special_ability_type)
);

CREATE TABLE tb_unit(
  id_unit integer NOT NULL,
  id_model integer NOT NULL,
  nm_unit text,
  vl_quantity integer,
  bl_is_reinforced boolean,
  CONSTRAINT tb_unit_pkey PRIMARY KEY(id_unit)
);

ALTER TABLE tb_model_statistic
  ADD CONSTRAINT fk_model_statistic
    FOREIGN KEY (id_model) REFERENCES tb_model (id_model);

ALTER TABLE tb_attack
  ADD CONSTRAINT fk_attack_model
    FOREIGN KEY (id_model) REFERENCES tb_model (id_model);

ALTER TABLE tb_ability
  ADD CONSTRAINT fk_ability_attack
    FOREIGN KEY (id_attack) REFERENCES tb_attack (id_attack);

ALTER TABLE tb_special_ability
  ADD CONSTRAINT fk_special_ability_model
    FOREIGN KEY (id_model) REFERENCES tb_model (id_model);

ALTER TABLE tb_special_ability
  ADD CONSTRAINT fk_special_ability_type
    FOREIGN KEY (id_special_ability_type)
      REFERENCES tb_special_ability_type (id_special_ability_type);

ALTER TABLE tb_unit
  ADD CONSTRAINT fk_unit_model
    FOREIGN KEY (id_model) REFERENCES tb_model (id_model);
