CREATE TABLE student (
NO INTEGER CONSTRAINT student_no_pk PRIMARY KEY, 
name varchar2(10), 
det varchar2(20), 
addr varchar2(80), 
tel varchar2(20));


INSERT INTO STUDENT VALUES (1, '홍길동', '국문학과', '서울', '010-1111-1111');
INSERT INTO STUDENT VALUES (2, '고길동', '수학과', '인천', '010-2222-2222');


SELECT * FROM STUDENT;