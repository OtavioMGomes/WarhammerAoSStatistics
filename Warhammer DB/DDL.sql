SET check_function_bodies = false;

create sequence sq_model;

create sequence sq_model_statistic;

create sequence sq_attack;

create sequence sq_unit;

create sequence sq_keyword;

CREATE TABLE tb_model(
id_model integer NOT NULL, nm_model text,
  CONSTRAINT pk_model_id PRIMARY KEY(id_model)
);

CREATE TABLE tb_model_statistic(
  id_model_statistic integer NOT NULL,
  id_model integer NOT NULL,
  nm_statistic text,
  vl_statistic text,
  CONSTRAINT pk_model_statistic_id PRIMARY KEY(id_model_statistic)
);

CREATE TABLE tb_keyword(
  id_keyword integer NOT NULL,
  id_model integer NOT NULL,
  ds_keyword text,
  CONSTRAINT pk_keyword_id PRIMARY KEY(id_keyword)
);

CREATE TABLE tb_attack(
  id_attack integer NOT NULL,
  id_model integer NOT NULL,
  nm_attack text,
  bl_is_shooting boolean,
  vl_range text,
  vl_attack_quantity text,
  vl_hit text,
  vl_wound text,
  vl_rend text,
  vl_damage text,
  CONSTRAINT pk_attack PRIMARY KEY(id_attack)
);

CREATE TABLE tb_unit(
  id_unit integer NOT NULL,
  id_model integer NOT NULL,
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

ALTER TABLE tb_unit
  ADD CONSTRAINT fk_unit_model
    FOREIGN KEY (id_model) REFERENCES tb_model (id_model);

ALTER TABLE tb_keyword
  ADD CONSTRAINT fk_keyword_model
    FOREIGN KEY (id_model) REFERENCES tb_model (id_model);
