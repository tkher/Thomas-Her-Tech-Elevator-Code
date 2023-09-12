-- 2. Select the filming_country and their average movie length (name this column 'avg_length_minutes') for all movies.
-- Order the results by the average movie length, highest first.
-- (20 rows, starting with 'Canada')

SELECT filming_country, AVG(length_minutes) AS avg_length_minutes
FROM movie
GROUP BY filming_country
ORDER BY avg_length_minutes DESC