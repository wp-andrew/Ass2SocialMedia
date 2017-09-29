SELECT object1 AS username FROM log WHERE predicate=3 and subject='rc_daniel' UNION SELECT subject AS username FROM log WHERE predicate=3 and object1='rc_daniel';

SELECT object2 FROM log WHERE predicate=4 AND subject IN (SELECT object1 FROM log WHERE predicate=3 AND subject='rc_daniel' UNION SELECT subject FROM log WHERE predicate=3 AND object1='rc_daniel' UNION SELECT 'rc_daniel');

SELECT t1.id, subject, content FROM (post AS t1) INNER JOIN (SELECT subject, object2 AS id FROM log WHERE predicate=4 AND datetime > (SELECT datetime FROM log WHERE predicate=1 AND subject='hs_tom') AND subject IN (SELECT object1 FROM log WHERE predicate=3 AND subject='hs_tom' UNION SELECT subject FROM log WHERE predicate=3 AND object1='hs_tom' UNION SELECT 'hs_tom')) AS t2 ON t1.id = t2.id;

SELECT subject, object2 FROM log WHERE predicate=4;

SELECT t2.* FROM (SELECT object1 FROM log WHERE predicate=3 AND subject='rc_daniel' UNION SELECT subject FROM log WHERE predicate=3 AND object1='rc_daniel') AS t1 INNER JOIN (SELECT * FROM user_profile) AS t2 ON t1.object1 = t2.username;

(SELECT * FROM log WHERE predicate=2 AND object1='ns_liam') UNION (SELECT * FROM log WHERE predicate=3 AND subject='ns_liam') UNION (SELECT * FROM log WHERE predicate=5 AND object2 IN (SELECT object2 FROM log WHERE predicate=4 AND subject='ns_liam')) ORDER BY datetime DESC;