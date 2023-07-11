drop table project cascade;
drop table project_worker cascade ;

create table project
(
    id          serial primary key,
    start_date  date,
    client_id   integer
        constraint project_client_id_fk
            references client on delete cascade,
    finish_date date,
    name varchar(255)
);
create table project_worker(
    project_id integer not null
    constraint project_worker_project_id_fk
    references project on delete cascade ,
    worker_id  integer not null
    constraint project_worker_worker_id_fk
    references worker on delete cascade ,
    constraint project_worker_pk
    primary key (project_id, worker_id)
);