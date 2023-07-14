-- 14. The names of actors who've appeared in the movies in the "Back to the Future Collection", sorted alphabetically.
-- (28 rows)

SELECT DISTINCT person_name
FROM person
JOIN movie_actor on person.person_id = movie_actor.actor_id
JOIN movie on movie_actor.movie_id = movie.movie_id
JOIN collection on movie.collection_id = collection.collection_id
WHERE collection.collection_name = 'Back to the Future Collection'
ORDER BY person_name; 