-- 12. Create a "Bill Murray Collection" in the collection table. For the movies that have Bill Murray in them, set their collection ID to the "Bill Murray Collection". (1 row, 6 rows)

--INSERT INTO collection (collection_name)
--VALUES ('Bill Murray Collection');

SELECT movie_id
FROM movie_actor 
Where movie_id = (SELECT movie_id FROM movie_actor WHERE actor_id = (SELECT person_id FROM person WHERE person_name = 'Bill Murray'));