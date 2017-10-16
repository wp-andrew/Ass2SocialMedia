INSERT INTO user_profile VALUES ('Daniel', 'Radcliffe', 'daniel.radcliffe@gmail.com', 'rc_daniel', '12345', 23, 7, 1989, 'male', 0, 1);
INSERT INTO entity_store VALUES (4, 'type', 'user');
INSERT INTO entity_store VALUES (4, 'class', 'node');
INSERT INTO entity_store VALUES (4, 'firstname', 'Daniel');
INSERT INTO entity_store VALUES (4, 'surname', 'Radcliffe');	
INSERT INTO entity_store VALUES (4, 'email', 'daniel.radcliffe@gmail.com');
INSERT INTO entity_store VALUES (4, 'username', 'rc_daniel');
INSERT INTO entity_store VALUES (4, 'birthdate', '23');
INSERT INTO entity_store VALUES (4, 'birthmonth', '7');
INSERT INTO entity_store VALUES (4, 'birthyear', '1989');
INSERT INTO entity_store VALUES (4, 'gender', 'male');

INSERT INTO user_profile VALUES ('Liam', 'Neeson', 'liam.neeson@gmail.com', 'ns_liam', '12345', 7, 6, 1952, 'male', 0, 1);
INSERT INTO entity_store VALUES (5, 'type', 'user');
INSERT INTO entity_store VALUES (5, 'class', 'node');
INSERT INTO entity_store VALUES (5, 'firstname', 'Liam');
INSERT INTO entity_store VALUES (5, 'surname', 'Neeson');	
INSERT INTO entity_store VALUES (5, 'email', 'liam.neeson@gmail.com');
INSERT INTO entity_store VALUES (5, 'username', 'ns_liam');
INSERT INTO entity_store VALUES (5, 'birthdate', '7');
INSERT INTO entity_store VALUES (5, 'birthmonth', '6');
INSERT INTO entity_store VALUES (5, 'birthyear', '1952');
INSERT INTO entity_store VALUES (5, 'gender', 'male');

INSERT INTO user_profile VALUES ('Tom', 'Hiddleston', 'tom.hiddleston@gmail.com', 'hs_tom', '12345', 9, 2, 1981, 'male', 0, 1);
INSERT INTO entity_store VALUES (6, 'type', 'user');
INSERT INTO entity_store VALUES (6, 'class', 'node');
INSERT INTO entity_store VALUES (6, 'firstname', 'Tom');
INSERT INTO entity_store VALUES (6, 'surname', 'Hiddleston');	
INSERT INTO entity_store VALUES (6, 'email', 'tom.hiddleston@gmail.com');
INSERT INTO entity_store VALUES (6, 'username', 'hs_tom');
INSERT INTO entity_store VALUES (6, 'birthdate', '9');
INSERT INTO entity_store VALUES (6, 'birthmonth', '2');
INSERT INTO entity_store VALUES (6, 'birthyear', '1981');
INSERT INTO entity_store VALUES (6, 'gender', 'male');

/*
INSERT INTO user_profile VALUES ('Johnny', 'Depp', 'johnny.depp@gmail.com', 'd_johnny', '12345', 9, 6, 1963, 'male', 0, 1);
INSERT INTO user_profile VALUES ('Hugh', 'Jackman', 'hugh.jackman@gmail.com', 'jm_hugh', '12345', 12, 10, 1968, 'male', 0, 1);
INSERT INTO user_profile VALUES ('Mila', 'Kunis', 'mila.kunis@gmail.com', 'kn_mila', '12345', 14, 8, 1983, 'female', 0, 1);
INSERT INTO user_profile VALUES ('Emma', 'Stone', 'emma.stone@gmail.com', 's_emma', '12345', 6, 11, 1988, 'female', 0, 1);
INSERT INTO user_profile VALUES ('Alexandra', 'Daddario', 'alexandra.daddario@gmail.com', 'dd_alexandra', '12345', 16, 3, 1986, 'female', 0, 1);
INSERT INTO user_profile VALUES ('Jennifer', 'Lawrence', 'jennifer.lawrence@gmail.com', 'lr_jennifer', '12345', 15, 8, 1990, 'female', 0, 1);
INSERT INTO user_profile VALUES ('Margot', 'Robbie', 'margot.robbie@gmail.com', 'rb_margot', '12345', 2, 7, 1990, 'female', 0, 1);
*/

INSERT INTO log (subject, predicate) VALUES ('rc_daniel', 1);

INSERT INTO post (content) VALUES ('post 2 content');
INSERT INTO entity_store VALUES (7, 'type', 'post');
INSERT INTO entity_store VALUES (7, 'class', 'node');
INSERT INTO entity_store VALUES (7, 'number', '2');
INSERT INTO entity_store VALUES (7, 'content', 'post 2 content');
INSERT INTO log (subject, predicate, object2) VALUES ('rc_daniel', 4, 2);
INSERT INTO triple_store VALUES (4, 2, 7);

INSERT INTO log (subject, predicate, object2) VALUES ('rc_daniel', 5, 2);
INSERT INTO triple_store VALUES (4, 3, 7);

INSERT INTO log (subject, predicate) VALUES ('ns_liam', 1);

INSERT INTO log (subject, predicate, object1) VALUES ('rc_daniel', 2, 'ns_liam');

INSERT INTO log (subject, predicate, object1) VALUES ('rc_daniel', 3, 'ns_liam');
INSERT INTO triple_store VALUES (4, 1, 5);

INSERT INTO log (subject, predicate) VALUES ('hs_tom', 1);

INSERT INTO log (subject, predicate, object1) VALUES ('hs_tom', 2, 'rc_daniel');

INSERT INTO log (subject, predicate, object1) VALUES ('hs_tom', 3, 'rc_daniel');
INSERT INTO triple_store VALUES (6, 1, 4);

INSERT INTO log (subject, predicate, object1) VALUES ('hs_tom', 2, 'ns_liam');

INSERT INTO log (subject, predicate, object1) VALUES ('hs_tom', 3, 'ns_liam');
INSERT INTO triple_store VALUES (6, 1, 5);

INSERT INTO post (content) VALUES ('post 3 content');
INSERT INTO entity_store VALUES (8, 'type', 'post');
INSERT INTO entity_store VALUES (8, 'class', 'node');
INSERT INTO entity_store VALUES (8, 'number', '3');
INSERT INTO entity_store VALUES (8, 'content', 'post 3 content');
INSERT INTO log (subject, predicate, object2) VALUES ('hs_tom', 4, 3);
INSERT INTO triple_store VALUES (6, 2, 8);

INSERT INTO post (content) VALUES ('post 4 content');
INSERT INTO entity_store VALUES (9, 'type', 'post');
INSERT INTO entity_store VALUES (9, 'class', 'node');
INSERT INTO entity_store VALUES (9, 'number', '4');
INSERT INTO entity_store VALUES (9, 'content', 'post 4 content');
INSERT INTO log (subject, predicate, object2) VALUES ('ns_liam', 4, 4);
INSERT INTO triple_store VALUES (5, 2, 9);

INSERT INTO log (subject, predicate, object2) VALUES ('ns_liam', 5, 3);
INSERT INTO triple_store VALUES (5, 3, 8);

INSERT INTO log (subject, predicate, object2) VALUES ('rc_daniel', 5, 3);
INSERT INTO triple_store VALUES (4, 3, 8);