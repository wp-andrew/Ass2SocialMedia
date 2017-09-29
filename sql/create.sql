DROP TABLE IF EXISTS user_profile;
CREATE TABLE user_profile (
	firstname   varchar(50)  DEFAULT NULL,
	surname     varchar(50)  DEFAULT NULL,
	email       varchar(150) DEFAULT NULL,
	username    varchar(50)  NOT NULL,
	password    varchar(50)  DEFAULT NULL,
	birthdate   int(2)       DEFAULT 0,
	birthmonth  int(2)       DEFAULT 0,
	birthyear   int(4)       DEFAULT 0,
	gender      varchar(50)  DEFAULT NULL,
	banned      boolean      DEFAULT 0,
	verified    boolean      DEFAULT 0,
	PRIMARY KEY (username)
);


DROP TABLE IF EXISTS post;
CREATE TABLE post (
	id          int(8)        NOT NULL AUTO_INCREMENT,
	content     varchar(1000),
	PRIMARY KEY (id)
);


DROP TABLE IF EXISTS operation;
CREATE TABLE operation (
	id          int(1)     NOT NULL AUTO_INCREMENT,
	description varchar(8) NOT NULL,
	PRIMARY KEY (id)
);


DROP TABLE IF EXISTS log;
CREATE TABLE log (
	datetime    timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP, 
	subject     varchar(50) NOT NULL REFERENCES user_profile(username),
	predicate   int(1)      NOT NULL REFERENCES operation(id),
	object1     varchar(50) NOT NULL DEFAULT '' REFERENCES user_profile(username),
	object2     int(8)      NOT NULL DEFAULT 1 REFERENCES post(id),
	PRIMARY KEY (subject, predicate, object1, object2)
);