-- 12. The titles of the movies in the "Star Wars Collection" that weren't directed by George Lucas, sorted alphabetically.
-- (5 rows)

SELECT title
FROM movie
JOIN collection on movie.collection_id = collection.collection_id
JOIN person on movie.director_id = person.person_id
WHERE person.person_name != 'George Lucas' AND collection.collection_name = 'Star Wars Collection'
ORDER BY title;