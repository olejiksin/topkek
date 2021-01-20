

create table online_users
(
    id     bigserial not null
        constraint online_users_pk
            primary key,
    name   varchar(100),
    online varchar(10)
);

alter table online_users
    owner to postgres;

create unique index online_users_id_uindex
    on online_users (id);

create unique index online_users_name_uindex
    on online_users (name);

create table test
(
    id      bigserial not null
        constraint test_pk
            primary key,
    message varchar(1000),
    user_id bigint
        constraint test_online_users__fk
            references online_users
);

alter table test
    owner to postgres;

create unique index test_id_uindex
    on test (id);

