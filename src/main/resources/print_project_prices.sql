WITH tur AS (
    SELECT
        p2.id,
        (DATE_PART('year', p2.finish_date) - DATE_PART('year', p2.start_date)) * 12 +
        (DATE_PART('month', p2.finish_date) - DATE_PART('month', p2.start_date)) AS duration
    FROM project p2
             JOIN project_worker pw ON p2.id = pw.project_id
)
SELECT
    p.name,
    SUM(tur.duration * w.salary) AS price
FROM
    project_worker pw
        INNER JOIN tur ON tur.id = pw.project_id
        INNER JOIN project p ON pw.project_id = p.id
        INNER JOIN worker w ON pw.worker_id = w.id
GROUP BY p.id
ORDER BY price DESC;