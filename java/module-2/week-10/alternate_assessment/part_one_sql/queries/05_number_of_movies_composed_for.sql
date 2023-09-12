-- 5. List the movie title, release year, and first and last name of the director (name the column 'director'), 
--    and first and last name of the composer (name the column 'composer') of all movies released in 2000 or later.
-- Order the results by the release year in descending order (highest first), then by alphabetical order by title.
-- (28 rows)

SELECT movie.title, movie.release_year, person.first_name | ' ' | person.last_name as director, person.first_name | ' ' | person.last_name as director