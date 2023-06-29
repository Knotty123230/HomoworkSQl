SELECT name, EXTRACT(year FROM finish_date) * 12 + EXTRACT(month FROM finish_date) -
                   EXTRACT(year FROM start_date) * 12 - EXTRACT(month FROM start_date) AS month_count
from project
WHERE EXTRACT(year FROM finish_date) * 12 + EXTRACT(month FROM finish_date) -
      EXTRACT(year FROM start_date) * 12 - EXTRACT(month FROM start_date) =
      (SELECT max(EXTRACT(year FROM finish_date) * 12 + EXTRACT(month FROM finish_date) -
                  EXTRACT(year FROM start_date) * 12 - EXTRACT(month FROM start_date))from project)

