(
    SELECT u.name AS results
    FROM Users u
    JOIN MovieRating m ON u.user_id = m.user_id
    GROUP BY u.user_id
    ORDER BY COUNT(*) DESC, u.name ASC
    LIMIT 1
)

UNION ALL

(
    SELECT mv.title AS results
    FROM Movies mv
    JOIN MovieRating m ON mv.movie_id = m.movie_id
    WHERE DATE_FORMAT(m.created_at, '%Y-%m') = '2020-02'
    GROUP BY mv.movie_id
    ORDER BY AVG(m.rating) DESC, mv.title ASC
    LIMIT 1
);