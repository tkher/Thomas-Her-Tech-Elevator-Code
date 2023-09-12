-- 4. List the genre name and the count (name this column 'total_movies') of the genre with the most movies. 
-- (1 row)

SELECT genre.name, count(movie.title) as total_movies
FROM genre
JOIN movie_genre ON movie_genre.genre_id = genre.genre_id
JOIN movie ON movie.movie_id = movie_genre.movie_id
GROUP BY genre.name;

--SELECT MAX(total_movies)