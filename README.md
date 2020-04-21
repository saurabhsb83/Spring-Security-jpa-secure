REST API with CRUD functionality using spring boot , data-jpa. REST API uses spring security based authentication and authorization with jdbc based encrypted passwords.
REST API is secured ( https ) with java keystore self signed certificate


User table for enforcing jdbc based authentication:

CREATE TABLE user (
  id int(11) NOT NULL AUTO_INCREMENT,
  user_name varchar(45) DEFAULT NULL,
  password varchar(45) DEFAULT NULL,
  roles varchar(100) DEFAULT NULL,
  active BOOLEAN DEFAULT NULL,
  PRIMARY KEY (id)
)  


INSERT : 
insert into user(user_name,password,roles,active) values('username','encrypted password hash','ROLE_USER,ROLE_MANAGER,ROLE_ADMIN',true);
