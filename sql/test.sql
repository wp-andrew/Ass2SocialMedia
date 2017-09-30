(SELECT * FROM log WHERE predicate=2 AND object1='rc_daniel')
UNION (SELECT * FROM log WHERE predicate=3 AND subject='rc_daniel')
UNION (SELECT * FROM log WHERE predicate=5 AND object2 IN (SELECT object2 FROM log WHERE predicate=4 AND subject='rc_daniel'))
ORDER BY datetime DESC;