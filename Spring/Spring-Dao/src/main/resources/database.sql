create table EMPLOYEE (
        id integer not null auto_increment,
        JOINING_DATE date not null,
        NAME varchar(50) not null,
        SALARY decimal(10,2) not null,
        SSN varchar(255) not null,
        primary key (id)
    );
    alter table EMPLOYEE 
        add constraint UK_p136ambt19xg166m0jf37p7wn  unique (SSN);
        
  INSERT INTO EMPLOYEE(NAME,SALARY,SSN,JOINING_DATE) values('Naveen',50000,'1234',now());