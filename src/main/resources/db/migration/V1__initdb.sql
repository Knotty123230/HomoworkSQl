create table client
(
    id   serial primary key,
    name varchar(1000)
        constraint check_name
            check ((length(name) > 2) AND (length(name) < 1000))
);

create table project
(
    id          serial primary key,
    start_date  date,
    client_id   integer
        constraint project_client_id_fk
            references client,
    finish_date date,
    name varchar
);
create table worker
(
    id       serial primary key ,
    name     varchar(1000) not null
        constraint check_name
            check ((length(name) > 2) AND (length(name) < 1000)),
    level    varchar(20) not null
        constraint check_level
            check (level IN ('junior', 'trainee', 'middle', 'senior')),
    salary   integer
        constraint check_salary
            check ((salary >= 100) AND (salary <= 100000)),
    birthday integer
        constraint check_birthday
            check (birthday >= 1900)
);


create table project_worker
(
    project_id integer not null
        constraint project_worker_project_id_fk
            references project,
    worker_id  integer not null
        constraint project_worker_worker_id_fk
            references worker,
    constraint project_worker_pk
        primary key (project_id, worker_id)
);

create index worker_id_index
    on worker (id);

create index project_id_index
    on project (id);
