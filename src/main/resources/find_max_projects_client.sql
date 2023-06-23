SELECT client.name, COUNT(project_worker.project_id) AS project_count
FROM project_worker
         INNER JOIN worker ON project_worker.worker_id = worker.id
         INNER JOIN project ON project_worker.project_id = project.id
         INNER JOIN client ON worker.id = client.id
GROUP BY client.id
HAVING COUNT(project_worker.project_id) = (
    SELECT MAX(project_count)
    FROM (
             SELECT COUNT(project_worker.project_id) AS project_count
             FROM project_worker
                      INNER JOIN worker ON project_worker.worker_id = worker.id
             GROUP BY worker_id
         ) as pwwpc
);