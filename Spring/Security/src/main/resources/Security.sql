CREATE  TABLE users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));
 
 CREATE TABLE authorities (
   username varchar(45) NOT NULL,
   authority varchar(45) NOT NULL,
   UNIQUE KEY uni_username_authority (authority,username),
   KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));
  
  

INSERT INTO users(username,password,enabled)VALUES ('naveen','naveen', true);

INSERT INTO authorities (username, authority)VALUES ('naveen', 'ROLE_ADMIN');

INSERT INTO users(username,password,enabled)VALUES ('kumar','kumar', true);
INSERT INTO authorities (username, authority)VALUES ('kumar', 'ROLE_USER');

delete from authorities where username='naveen';
delete from users where username='naveen';

INSERT INTO users(username,password,enabled)VALUES ('naveen','e691cb702f5d25642aa87009ef1948f8', true);
INSERT INTO authorities (username, authority)VALUES ('naveen', 'ROLE_ADMIN');

delete from authorities where username='kumar';
delete from users where username='kumar';

INSERT INTO users(username,password,enabled)VALUES ('kumar','79cfac6387e0d582f83a29a04d0bcdc4', true);
INSERT INTO authorities (username, authority)VALUES ('kumar', 'ROLE_USER');

