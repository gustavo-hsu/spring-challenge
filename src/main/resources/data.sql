DROP TABLE IF EXISTS users;

CREATE TABLE user (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name varchar NOT NULL
);

CREATE TABLE follower (
  from_user_id INT NOT NULL ,
  to_user_id INT NOT NULL
);

