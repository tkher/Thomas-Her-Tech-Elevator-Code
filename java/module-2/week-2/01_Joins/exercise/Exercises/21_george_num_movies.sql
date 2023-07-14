-- 21. For every person in the person table with the first name of "George", list the number of movies they've been in. Name the count column 'num_of_movies'.
-- Include all Georges, even those that have not appeared in any movies. Display the names in alphabetical order. 
-- (59 rows)

SELECT person_name, count(*)AS num_of_movies
FROM person
LEFT OUTER JOIN movie_actor on person.person_id = movie_actor.actor_id
LEFT OUTER JOIN movie ON movie_actor.movie_id = movie.movie_id
WHERE person_name like 'George %'
GROUP BY person.person_id, person_name
ORDER BY person_name
