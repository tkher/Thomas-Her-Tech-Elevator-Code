-- 13. The directors of the movies in the "Harry Potter Collection", sorted alphabetically.
-- (4 rows)

SELECT DISTINCT person_name
FROM person
JOIN movie on movie.director_id = person.person_id
JOIN collection on movie.collection_id = collection.collection_id
WHERE collection.collection_name = 'Harry Potter Collection'
ORDER BY person_name; 