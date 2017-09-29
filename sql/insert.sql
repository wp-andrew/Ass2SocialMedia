INSERT INTO user_profile VALUES ('Daniel', 'Radcliffe', 'daniel.radcliffe@gmail.com', 'rc_daniel', '12345', 23, 7, 1989, 'male', 0, 1);
INSERT INTO user_profile VALUES ('Liam', 'Neeson', 'liam.neeson@gmail.com', 'ns_liam', '12345', 7, 6, 1952, 'male', 0, 1);
INSERT INTO user_profile VALUES ('Tom', 'Hiddleston', 'tom.hiddleston@gmail.com', 'hs_tom', '12345', 9, 2, 1981, 'male', 0, 1);
INSERT INTO user_profile VALUES ('Johnny', 'Depp', 'johnny.depp@gmail.com', 'd_johnny', '12345', 9, 6, 1963, 'male', 0, 1);
INSERT INTO user_profile VALUES ('Hugh', 'Jackman', 'hugh.jackman@gmail.com', 'jm_hugh', '12345', 12, 10, 1968, 'male', 0, 1);
INSERT INTO user_profile VALUES ('Mila', 'Kunis', 'mila.kunis@gmail.com', 'kn_mila', '12345', 14, 8, 1983, 'female', 0, 1);
INSERT INTO user_profile VALUES ('Emma', 'Stone', 'emma.stone@gmail.com', 's_emma', '12345', 6, 11, 1988, 'female', 0, 1);
INSERT INTO user_profile VALUES ('Alexandra', 'Daddario', 'alexandra.daddario@gmail.com', 'dd_alexandra', '12345', 16, 3, 1986, 'female', 0, 1);
INSERT INTO user_profile VALUES ('Jennifer', 'Lawrence', 'jennifer.lawrence@gmail.com', 'lr_jennifer', '12345', 15, 8, 1990, 'female', 0, 1);
INSERT INTO user_profile VALUES ('Margot', 'Robbie', 'margot.robbie@gmail.com', 'rb_margot', '12345', 2, 7, 1990, 'female', 0, 1);

INSERT INTO log (subject, predicate) VALUES ('rc_daniel', 1);

INSERT INTO post (content) VALUES ('post 2 content');
INSERT INTO log (subject, predicate, object2) VALUES ('rc_daniel', 4, 2);

INSERT INTO log (subject, predicate, object2) VALUES ('rc_daniel', 5, 2);

INSERT INTO log (subject, predicate) VALUES ('ns_liam', 1);

INSERT INTO log (subject, predicate, object1) VALUES ('rc_daniel', 2, 'ns_liam');

INSERT INTO log (subject, predicate, object1) VALUES ('rc_daniel', 3, 'ns_liam');

INSERT INTO log (subject, predicate) VALUES ('hs_tom', 1);

INSERT INTO log (subject, predicate, object1) VALUES ('hs_tom', 2, 'rc_daniel');

INSERT INTO log (subject, predicate, object1) VALUES ('hs_tom', 3, 'rc_daniel');

INSERT INTO log (subject, predicate, object1) VALUES ('hs_tom', 2, 'ns_liam');

INSERT INTO log (subject, predicate, object1) VALUES ('hs_tom', 3, 'ns_liam');

INSERT INTO post (content) VALUES ('post 3 content');
INSERT INTO log (subject, predicate, object2) VALUES ('hs_tom', 4, 3);

INSERT INTO post (content) VALUES ('post 4 content');
INSERT INTO log (subject, predicate, object2) VALUES ('ns_liam', 4, 4);

INSERT INTO log (subject, predicate, object2) VALUES ('ns_liam', 5, 3);

INSERT INTO log (subject, predicate, object2) VALUES ('rc_daniel', 5, 3);