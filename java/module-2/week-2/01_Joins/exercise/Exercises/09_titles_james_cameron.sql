-- 9. The titles of movies directed by James Cameron, sorted alphabetically.
-- (6 rows)

SELECT title
from movie
JOIN person on movie.director_id = person.person_id
Where person.person_name = 'James Cameron'
ORDER BY movie.title


