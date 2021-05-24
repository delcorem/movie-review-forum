CREATE TABLE review(
	movieid LONG PRIMARY KEY AUTO_INCREMENT,
	moviename VARCHAR(255),
	moviereview VARCHAR(10000),
	reviewdate DATE,
	reviewtime TIME
);