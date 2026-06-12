CREATE TABLE SCHOLARS (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age int,
    scholar_group int,
    scholar_type VARCHAR(100) NOT NULL,
    course VARCHAR(100) NOT NULL
);

create sequence SEQ_SCHOLARS
minvalue 1
maxvalue 999999999999999999
start with 1
increment by 1;

-- --1
-- INSERT INTO DISTRICTS (id, value, order_position)
-- VALUES ((SELECT nextval('seq_districts')), 'София', 1);
-- --2
-- INSERT INTO DISTRICTS (id, value, order_position)
-- VALUES ((SELECT nextval('seq_districts')), 'Пловдив', 2);
-- --3
-- INSERT INTO DISTRICTS (id, value, order_position)
-- VALUES ((SELECT nextval('seq_districts')), 'Варна', 3);
-- --4
-- INSERT INTO DISTRICTS (id, value, order_position)
-- VALUES ((SELECT nextval('seq_districts')), 'Бургас', 4);
-- --5
-- INSERT INTO DISTRICTS (id, value, order_position)
-- VALUES ((SELECT nextval('seq_districts')), 'Русе', 5);
-- --6
-- INSERT INTO DISTRICTS (id, value, order_position)
-- VALUES ((SELECT nextval('seq_districts')), 'Стара загора', 6);
-- --7
-- INSERT INTO DISTRICTS (id, value)
-- VALUES ((SELECT nextval('seq_districts')), 'Благоевград');
-- --8
-- INSERT INTO DISTRICTS (id, value)
-- VALUES ((SELECT nextval('seq_districts')), 'Велико Търново');
-- --9
-- INSERT INTO DISTRICTS (id, value)
-- VALUES ((SELECT nextval('seq_districts')), 'Видин');
-- --10
-- INSERT INTO DISTRICTS (id, value)
-- VALUES ((SELECT nextval('seq_districts')), 'Враца');
-- --11
-- INSERT INTO DISTRICTS (id, value)
-- VALUES ((SELECT nextval('seq_districts')), 'Габрово');
-- --12
-- INSERT INTO DISTRICTS (id, value)
-- VALUES ((SELECT nextval('seq_districts')), 'Добрич');
-- --13
-- INSERT INTO DISTRICTS (id, value)
-- VALUES ((SELECT nextval('seq_districts')), 'Кърджали');
-- --14
-- INSERT INTO DISTRICTS (id, value)
-- VALUES ((SELECT nextval('seq_districts')), 'Кюстендил');
-- --15
-- INSERT INTO DISTRICTS (id, value)
-- VALUES ((SELECT nextval('seq_districts')), 'Ловеч');
-- --16
-- INSERT INTO DISTRICTS (id, value)
-- VALUES ((SELECT nextval('seq_districts')), 'Монтана');
-- --17
-- INSERT INTO DISTRICTS (id, value)
-- VALUES ((SELECT nextval('seq_districts')), 'Пазарджик');
-- --18
-- INSERT INTO DISTRICTS (id, value)
-- VALUES ((SELECT nextval('seq_districts')), 'Перник');
-- --19
-- INSERT INTO DISTRICTS (id, value)
-- VALUES ((SELECT nextval('seq_districts')), 'Плевен');
-- --20
-- INSERT INTO DISTRICTS (id, value)
-- VALUES ((SELECT nextval('seq_districts')), 'Разград');
-- --21
-- INSERT INTO DISTRICTS (id, value)
-- VALUES ((SELECT nextval('seq_districts')), 'Силистра');
-- --22
-- INSERT INTO DISTRICTS (id, value)
-- VALUES ((SELECT nextval('seq_districts')), 'Сливен');
-- --23
-- INSERT INTO DISTRICTS (id, value)
-- VALUES ((SELECT nextval('seq_districts')), 'Смолян');
-- --24
-- INSERT INTO DISTRICTS (id, value)
-- VALUES ((SELECT nextval('seq_districts')), 'Търговище');
-- --25
-- INSERT INTO DISTRICTS (id, value)
-- VALUES ((SELECT nextval('seq_districts')), 'Хасково');
-- --26
-- INSERT INTO DISTRICTS (id, value)
-- VALUES ((SELECT nextval('seq_districts')), 'Шумен');
-- --27
-- INSERT INTO DISTRICTS (id, value)
-- VALUES ((SELECT nextval('seq_districts')), 'Ямбол');
--
--
