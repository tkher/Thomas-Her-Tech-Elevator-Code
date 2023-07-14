-- 15. The title of the movie and the name of director for movies where the director was also an actor in the same movie.
-- Order the results by movie title (A-Z)
-- (73 rows)

SELECT title, person.person_name
from movie 
JOIN movie_actor on movie.movie_id = movie_actor.movie_id
JOIN person on movie_actor.actor_id = person.person_id
JOIN movie on person.person_id = movie.director_id
Where (SELECT person.person_name from person) = (SELECT )