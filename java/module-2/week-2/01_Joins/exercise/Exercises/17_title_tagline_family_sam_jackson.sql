-- 17. The titles and taglines of movies that are in the "Family" genre that Samuel L. Jackson has acted in.
-- Order the results alphabetically by movie title.
-- (4 rows)

SELECT title, tagline
FROM movie
JOIN movie_genre on movie.movie_id = movie_genre.movie_id
JOIN genre on movie_genre.genre_id = genre.genre_id
JOIN movie_actor on movie.movie_id = movie_actor.movie_id
JOIN person on movie_actor.actor_id = person.person_id
WHERE genre.genre_name = 'Family' AND person.person_name = 'Samuel L. Jackson'
ORDER BY title;