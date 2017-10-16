SELECT max(subject) + 1 as ID FROM entity_store;

SELECT subject AS id FROM entity_store WHERE predicate='label' AND object='liked';
UPDATE entity_store SET object='liked' WHERE subject=3 AND predicate='label';