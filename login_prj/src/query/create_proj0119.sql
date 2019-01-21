CREATE TABLE simple_login(
    id VARCHAR2(15) CONSTRAINT pk_simple_login PRIMARY KEY,  
    name varchar2(20) NOT NULL,
    password VARCHAR2(10) NOT NULL,
    tel CHAR(13) NOT NULL,
    email VARCHAR2(30) NOT NULL,
    address VARCHAR2(200) NOT NULL,
    ssn CHAR(14) CONSTRAINT uk_simple_login UNIQUE,
    question CHAR(1) NOT NULL,
    answer VARCHAR2(30) NOT NULL
);


insert into simple_login(ID, NAME, PASSWORD,TEL,EMAIL, ADDRESS, SSN, QUESTION, ANSWER)
values('gkwl','공선의','1234','010-2222-2222','gggg@naver.com','서울시 양천구 신정7동','666666-6666666','2','ㅇㄹㄴㄹㅇㄹ');
insert into simple_login(ID, NAME, PASSWORD,TEL,EMAIL, ADDRESS, SSN, QUESTION, ANSWER)
values('test','테스트','1234','010-2262-2222','test@naver.com','서울시 강남구 구로동','226466-6666666','4','ㅋㅋㅋ');
select * from SIMPLE_LOGIN  ;
commit;
