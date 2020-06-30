create schema public;

comment on schema public is 'standard public schema';

alter schema public owner to postgres;

create table "user"
(
    id bigserial not null
        constraint users_pk
            primary key
);

alter table "user" owner to postgres;

create unique index users_id_uindex
    on "user" (id);

create table message
(
    id bigserial not null
        constraint messages_pk
            primary key,
    user_id bigint not null
        constraint messages_users_id_fk
            references "user",
    value varchar not null
);

alter table message owner to postgres;

create unique index messages_id_uindex
    on message (id);

