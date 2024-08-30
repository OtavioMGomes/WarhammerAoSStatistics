--===================================================================================================================
----------------------------------------------- TB_MODEL ------------------------------------------------------------
--===================================================================================================================

insert into tb_model values (nextval('sq_model'), 'Mortek Guard');
insert into tb_model values (nextval('sq_model'), 'Gothizzar Harvester');

--===================================================================================================================
----------------------------------------------- TB_UNIT -------------------------------------------------------------
--===================================================================================================================

insert into tb_unit values (nextval('sq_unit'), 1, 10, false);
insert into tb_unit values (nextval('sq_unit'), 2, 1, false);

--===================================================================================================================
----------------------------------------------- TB_MODEL_STATISTIC --------------------------------------------------
--===================================================================================================================

insert into tb_model_statistic values (nextval('sq_model_statistic'), 1, 'Health', '1');
insert into tb_model_statistic values (nextval('sq_model_statistic'), 1, 'Move', '4');
insert into tb_model_statistic values (nextval('sq_model_statistic'), 1, 'Save', '4+');
insert into tb_model_statistic values (nextval('sq_model_statistic'), 1, 'Control', '1');

insert into tb_model_statistic values (nextval('sq_model_statistic'), 2, 'Health', '10');
insert into tb_model_statistic values (nextval('sq_model_statistic'), 2, 'Move', '6');
insert into tb_model_statistic values (nextval('sq_model_statistic'), 2, 'Save', '4+');
insert into tb_model_statistic values (nextval('sq_model_statistic'), 2, 'Control', '5');

--===================================================================================================================
----------------------------------------------- TB_ATTACK -----------------------------------------------------------
--===================================================================================================================

insert into tb_attack values (nextval('sq_attack'), 1, 'Nadirite Weapons', false, null, '2', '3+', '4+', '0', '1');

insert into tb_attack values (nextval('sq_attack'), 2, 'Deaths Head Maw', true,  '12', '4', '4+', '4+', '-1', '1');
insert into tb_attack values (nextval('sq_attack'), 2, 'Ossified Hooves and Tail', false, null, '4', '4+', '3+', '-1', '2');
insert into tb_attack values (nextval('sq_attack'), 2, 'Soulcrusher Weapons', false, null, '6', '4+', '2+', '-2', '2');

--===================================================================================================================
----------------------------------------------- TB_KEYWORD ----------------------------------------------------------
--===================================================================================================================

insert into tb_keyword values (nextval('sq_keyword'), 1, 'INFANTRY');
insert into tb_keyword values (nextval('sq_keyword'), 1, 'CHAMPION');
insert into tb_keyword values (nextval('sq_keyword'), 1, 'STANDARD BEARER (1/10)');
insert into tb_keyword values (nextval('sq_keyword'), 1, 'WARD (6+)');
insert into tb_keyword values (nextval('sq_keyword'), 1, 'DEATH');
insert into tb_keyword values (nextval('sq_keyword'), 1, 'OSSIARCH BONEREAPERS');

insert into tb_keyword values (nextval('sq_keyword'), 2, 'MONSTER');
insert into tb_keyword values (nextval('sq_keyword'), 2, 'WARD (6+)');
insert into tb_keyword values (nextval('sq_keyword'), 2, 'DEATH');
insert into tb_keyword values (nextval('sq_keyword'), 2, 'OSSIARCH BONEREAPERS');
