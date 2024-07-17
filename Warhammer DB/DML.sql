--===================================================================================================================
----------------------------------------------- TB_MODEL ------------------------------------------------------------
--===================================================================================================================

insert into tb_model values (nextval('sq_model'), 'Mortek Guard');
insert into tb_model values (nextval('sq_model'), 'Gothizzar Harvester');

--===================================================================================================================
----------------------------------------------- TB_MODEL_STATISTIC --------------------------------------------------
--===================================================================================================================

insert into tb_model_statistic values (nextval('sq_model_statistic'), 1, 'Health', 1);
insert into tb_model_statistic values (nextval('sq_model_statistic'), 1, 'Move', 4);
insert into tb_model_statistic values (nextval('sq_model_statistic'), 1, 'Save', 4);
insert into tb_model_statistic values (nextval('sq_model_statistic'), 1, 'Control', 1);

insert into tb_model_statistic values (nextval('sq_model_statistic'), 2, 'Health', 10);
insert into tb_model_statistic values (nextval('sq_model_statistic'), 2, 'Move', 6);
insert into tb_model_statistic values (nextval('sq_model_statistic'), 2, 'Save', 4);
insert into tb_model_statistic values (nextval('sq_model_statistic'), 2, 'Control', 5);

--===================================================================================================================
----------------------------------------------- TB_ATTACK -----------------------------------------------------------
--===================================================================================================================

insert into tb_attack values (nextval('sq_attack'), 1, 'Nadirite Weapons', null, 2, 3, 4, 0, 1);

insert into tb_attack values (nextval('sq_attack'), 2, 'Deaths Head Maw', 12, 4, 4, 4, 1, 1);
insert into tb_attack values (nextval('sq_attack'), 2, 'Soulcrusher Weapons', null, 6, 4, 2, 2, 2);
insert into tb_attack values (nextval('sq_attack'), 2, 'Ossified Hooves and Tail', null, 4, 4, 3, 1, 2);

--===================================================================================================================
----------------------------------------------- TB_UNIT -------------------------------------------------------------
--===================================================================================================================

insert into tb_unit values (nextval('sq_unit'), 1, 'Mortek Guard', 10, false);
insert into tb_unit values (nextval('sq_unit'), 2, 'Gothizzar Harvester', 1, false);