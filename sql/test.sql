SELECT t1.id, datetime, subject, content FROM (post AS t1) 
INNER JOIN (SELECT datetime, subject, object2 AS id FROM log 
WHERE predicate=4 AND datetime > (SELECT datetime FROM log 
WHERE predicate=1 AND subject='rc_daniel') 
AND subject IN (SELECT object1 FROM log WHERE predicate=3 AND subject='rc_daniel' 
UNION SELECT subject FROM log WHERE predicate=3 AND object1='rc_daniel' 
UNION SELECT 'rc_daniel')) AS t2 ON t1.id = t2.id ORDER BY t1.id DESC;

SELECT datetime, object1 AS friend FROM log WHERE predicate=3 AND subject='rc_daniel' 
UNION SELECT datetime, subject AS friend FROM log WHERE predicate=3 AND object1='rc_daniel'

SELECT datetime, subject, object2 AS id FROM log 
WHERE predicate=4 AND datetime > (SELECT datetime FROM log 
WHERE predicate=1 AND subject='rc_daniel')

CREATE TABLE friend_list AS SELECT datetime, object1 AS friend FROM log WHERE predicate=3 AND subject='rc_daniel' 
UNION SELECT datetime, subject AS friend FROM log WHERE predicate=3 AND object1='rc_daniel';

SELECT t1.id, datetime, subject, content FROM (post AS t1) 
INNER JOIN ((SELECT t2.datetime, subject, object2 AS id FROM log AS t2, 
(SELECT datetime, object1 AS friend FROM log WHERE predicate=3 AND subject='rc_daniel' 
UNION SELECT datetime, subject AS friend FROM log WHERE predicate=3 AND object1='rc_daniel') AS t3
WHERE t2.subject=t3.friend AND predicate=4 AND t2.datetime>t3.datetime)
UNION (SELECT datetime, subject, object2 AS id FROM log WHERE subject='rc_daniel' AND predicate=4)) 
AS t4 ON t1.id = t4.id ORDER BY t1.id DESC;

"SELECT t1.id, datetime, subject, content FROM (post AS t1) "
+ "INNER JOIN ((SELECT t2.datetime, subject, object2 AS id FROM log AS t2, "
+ "(SELECT datetime, object1 AS friend FROM log WHERE predicate=3 AND subject='rc_daniel' "
+ "UNION SELECT datetime, subject AS friend FROM log WHERE predicate=3 AND object1='rc_daniel') AS t3 "
+ "WHERE t2.subject=t3.friend AND predicate=4 AND t2.datetime>t3.datetime) "
+ "UNION (SELECT datetime, subject, object2 AS id FROM log WHERE subject='rc_daniel' AND predicate=4)) "
+ "AS t4 ON t1.id = t4.id ORDER BY t1.id DESC;"