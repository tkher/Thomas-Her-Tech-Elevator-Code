-- 1. The name and population of all cities in Ohio (OH) (6 rows)
Select city_name, population
from city
where state_abbreviation = 'OH';
