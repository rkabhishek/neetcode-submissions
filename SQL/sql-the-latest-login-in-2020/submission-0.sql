-- Write your query below
SELECT user_id, MAX(time_stamp) AS last_stamp
FROM logins
WHERE EXTRACT(YEAR FROM time_stamp::timestamp) = 2020
GROUP BY user_id;

-- SELECT pg_typeof(time_stamp)
-- FROM logins
-- LIMIT 1;