

create table if not exists stomp_mes
(
	id bigserial not null
		constraint stomp_mes_pk
			primary key,
	usver varchar(255),
	message varchar(500),
	room integer,
	type varchar(255)
);

alter table stomp_mes owner to postgres;

create unique index if not exists stomp_mes_id_uindex
	on stomp_mes (id);



