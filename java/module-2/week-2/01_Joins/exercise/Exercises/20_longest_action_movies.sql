-- 20. The titles, lengths, and release dates of the 5 longest movies in the "Action" genre. 
-- Order the movies by length (highest first), then by release date (latest first).
-- (5 rows, expected lengths around 180 - 200)

SELECT title, length_minutes, release_date
FROM movie
JOIN movie_genre ON movie.movie_id = movie_genre.movie_id
JOIN genre on movie_genre.genre_id = genre.genre_id
WHERE genre.genre_name = 'Action'
ORDER BY length_minutes DESC, release_date DESC LIMIT 5;