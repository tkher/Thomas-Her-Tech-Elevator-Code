-- 4. Add a "Sports" genre to the genre table. Add the movie "Coach Carter" to the newly created genre. (1 row each)

INSERT INTO genre (genre_name)
VALUES ('Sports');
--RETURNING genre_id, genre_name;

UPDATE movie_genre 
SET genre_id = 11771
WHERE movie_id = (SELECT movie_id FROM movie WHERE title = 'Coach Carter');
--RETURNING genre_id, movie_id;

--SELECT title, movie_id
--from movie 
--where title = 'Coach Carter';