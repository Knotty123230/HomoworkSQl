insert into client
(name) VALUES
               ('vova'),
               ('kolia'),
               ('jenia'),
               ('serioga'),
               ('madam'),
               ('oleg'),
               ('anton'),
               ('vasia'),
               ('rum'),
               ('ania');
insert into project
( start_date, client_id, finish_date, name) VALUES
               ('01-01-2023', 1, '02-10-2024', 'project a'),
               ('01-01-2023', 2, '02-10-2025', 'project b'),
               ('01-01-2023', 3, '02-10-2026', 'project c'),
               ('01-01-2023', 4, '02-10-2027', 'project d'),
               ('01-01-2023', 5, '02-10-2028', 'project e'),
               ('01-01-2023', 6, '02-10-2029', 'project f'),
               ('01-01-2023', 7, '02-10-2030', 'project g'),
               ('01-01-2023', 8, '02-10-2031', 'project j'),
                ('01-01-2023', 9, '02-10-2032', 'project k'),
                ('01-01-2023', 10, '02-10-2033', 'project m');
insert into worker
(name, level, salary, birthday) values
                                    ('vova', 'trainee', 203, 2003),
                                    ('kolia', 'trainee', 402, 2001),
                                    ('vania', 'junior', 1920, 1920),
                                    ('sania', 'junior', 1922, 1944),
                                    ('kila', 'middle', 2005, 2006),
                                    ('mia', 'middle', 2550, 1944),
                                    ('ria', 'senior', 3550, 1947),
                                    ('vitalii', 'senior', 3570, 1940),
                                    ('sia', 'senior', 4000, 1999),
                                    ('ramil', 'senior', 2999, 1989);
insert into project_worker
(project_id, worker_id) VALUES
                            (1, 10),
                            (1, 2),
                            (1, 9),
                            (2, 1),
                            (2, 4),
                            (2, 6),
                            (3, 3),
                            (3, 8),
                            (4, 9),
                            (5, 10),
                            (5, 9),
                            (6, 7),
                            (6, 1),
                            (7, 2),
                            (7, 3),
                            (8, 2),
                            (9, 9),
                            (9, 2),
                            (9, 7),
                            (10, 4);

