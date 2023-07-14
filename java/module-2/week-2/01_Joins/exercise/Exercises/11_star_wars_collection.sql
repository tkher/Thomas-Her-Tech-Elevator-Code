-- 11. The titles of the movies in the "Star Wars Collection" ordered by release date, most recent first. 
-- (9 rows)

SELECT title
FROM movie
JOIN collection on movie.collection_id = collection.collection_id
WHERE collection.collection_name = 'Star Wars Collection'
ORDER BY release_date DESC