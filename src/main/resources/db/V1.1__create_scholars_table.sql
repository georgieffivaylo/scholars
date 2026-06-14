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
