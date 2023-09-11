-- 2. Select the name of the publisher with the most books published that are not out of print.
-- Select the number of books published by them (name the column 'books_in_print').
-- (1 row)

SELECT first_name
FROM person JOIN book_author ON book_author.author_id = person.person_id
JOIN book ON book.book_id = book_author.book_id
WHERE out_of_print = false
GROUP BY count(*)