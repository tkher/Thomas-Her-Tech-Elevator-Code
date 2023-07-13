-- 1. The titles and release dates of movies that Tom Hanks has appeared in. 
-- Order the results by release date, newest to oldest.
-- (47 rows)
Select title, release_date
from movie
join movie_actor on movie.movie_id = movie_actor.movie_id
join person on movie_actor.actor_id = person.person_id
Where person.person_name = 'Tom Hanks'
Order by movie.release_date DESC;

