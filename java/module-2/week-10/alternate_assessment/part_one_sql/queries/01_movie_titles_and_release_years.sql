-- 1. List the title and release year of all the movies with the Action genre. 
-- Order the results by release year, earliest first.
-- (5 rows)

SELECT title, release_year
FROM movie
JOIN movie_genre ON movie_genre.movie_id = movie.movie_id
JOIN genre ON genre.genre_id = movie_genre.genre_id
WHERE genre.name = 'Action'
ORDER BY release_year ASC