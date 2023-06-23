SELECT  sub.name, sub.date
FROM (
         SELECT project.name,
                 MAX((DATE_PART('year', finish_date) - DATE_PART('year', start_date)) * 12 +
                    (DATE_PART('month', finish_date) - DATE_PART('month', start_date))) AS date
         FROM project
         GROUP BY  finish_date, start_date, project.name
     ) sub
         JOIN (
    SELECT MAX((DATE_PART('year', finish_date) - DATE_PART('year', start_date)) * 12 +
               (DATE_PART('month', finish_date) - DATE_PART('month', start_date))) AS max_date
    FROM project
) max_sub
              ON sub.date = max_sub.max_date
ORDER BY sub.date DESC;