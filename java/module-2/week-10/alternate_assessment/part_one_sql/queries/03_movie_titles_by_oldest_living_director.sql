-- 3. List the title, first and last name of the director (name the column 'director'), 
--    and release year of all movies with a living director. 
-- Order the results by the director's age, oldest first.

-- Tip: Remember to add a space between the director's first and last names.
-- Tip: A director is considered living if there isn't a 'deathdate'.
-- (42 rows)

SELECT title, person.first_name || ' ' || person.last_name AS director, release_year
FROM movie
JOIN person on person.person_id = movie.director_id
WHERE deathdate isnull
ORDER BY person.birthdate