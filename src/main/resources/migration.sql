CREATE TABLE user (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name varchar NOT NULL
);

CREATE TABLE follower (
  from_user_id INT NOT NULL ,
  to_user_id INT NOT NULL
);

CREATE TABLE product (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  product_name VARCHAR,
  type VARCHAR,
  brand VARCHAR,
  color VARCHAR,
  notes VARCHAR
  category INT,
  price DOUBLE
);

CREATE TABLE post (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id INT NOT NULL,
  product_id INT NOT NULL
  post_date DATE,
  FOREIGN KEY (user_id) references user,
  FOREIGN KEY (product_id) references product,
 );
