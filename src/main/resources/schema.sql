CREATE TABLE product (
	    id   INTEGER  NOT NULL AUTO_INCREMENT,
	    name VARCHAR(128) NOT NULL,
	    description VARCHAR(255) NOT NULL,
	    organisation VARCHAR(128) NOT NULL,
	    PRIMARY KEY (id)
	);
CREATE TABLE review (
       id  INTEGER NOT NULL AUTO_INCREMENT,
       product_id INTEGER NOT NULL,
	   author VARCHAR(100) NOT NULL,
	   title VARCHAR(100) NOT NULL,
	   organisation VARCHAR(128) NOT NULL,
	   score INTEGER,
	   created_At TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	   PRIMARY KEY (id),
	   FOREIGN KEY (product_id) REFERENCES product (id)
	 );
CREATE TABLE comment(
id  INTEGER NOT NULL AUTO_INCREMENT,
feedback TEXT,
likes long,
dislikes long,
review_id INTEGER NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (review_id) REFERENCES review (id)
);