DROP TABLE IF EXISTS dog_breed;
DROP TABLE IF EXISTS breed;
DROP TABLE IF EXISTS dog;
DROP TABLE IF EXISTS location;

CREATE TABLE location (
  location_id int NOT NULL AUTO_INCREMENT,
  buisness_name  VARCHAR(256) NOT NULL,
  street_address  VARCHAR(128) NOT NULL,
  city  VARCHAR(60),
  state  VARCHAR(40),
  zip  VARCHAR(20),
  phione  VARCHAR(30),
  PRIMARY KEY (location_id)
);
CREATE TABLE dog (
  dog_id int NOT NULL AUTO_INCREMENT,
  location_id int NULL,
  name  VARCHAR(60) NOT NULL,
  age int,
  color  VARCHAR(128),  
  PRIMARY KEY (dog_id),
  FOREIGN KEY (location_id) REFERENCES location (location_id) ON DELETE CASCADE
);
CREATE TABLE breed (
  breed_id int NOT NULL AUTO_INCREMENT,
  name  VARCHAR(128), 
  PRIMARY KEY (breed_id)
);
CREATE TABLE dog_breed (
  dog_id int NOT NULL,
  breed_id int NOT NULL,
  FOREIGN KEY (dog_id) REFERENCES dog (dog_id) ON DELETE CASCADE,
  FOREIGN KEY (breed_id) REFERENCES breed (breed_id) ON DELETE CASCADE
);
