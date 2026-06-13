--1
INSERT INTO SCHOLARS (id, name, age, scholar_group, scholar_type, course)
VALUES ((SELECT nextval('seq_scholars')), 'Ivaylo', 35, 1, 'STUDENT', 'MAIN');
--2
INSERT INTO SCHOLARS (id, name, age, scholar_group, scholar_type, course)
VALUES ((SELECT nextval('seq_scholars')), 'Peter', 55, 1, 'TEACHER', 'SECONDARY');






