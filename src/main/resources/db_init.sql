insert into role (id, role) values (1, 'ADMIN');
insert into role (id, role) values (2, 'USER');
insert into users (id, password, username) values (1, 'ivan', 'ivan'), (2, 'nikola', 'nikola'), (3, 'zoran', 'zoran');
insert into user_role (role_id, user_id) values (1, 1), (2, 1), (2, 2), (2, 3);
insert into event (id, date, name, whole_day, creator) values (1, now(), 'first event', true, 1);
insert into event (id, date, name, whole_day, creator) values (2, now(), 'event 2', true, 1);
insert into event (id, date, name, whole_day, creator) values (3, now(), 'event 3', true, 1);
insert into user_event (event_id, user_id) values (1, 1);
insert into user_event (event_id, user_id) values (2, 1);
insert into user_event (event_id, user_id) values (3, 1);

alter sequence hibernate_sequence restart with 10;

insert into rola (naziv_role) values ('ADMIN'), ('PROFESOR'), ('STUDENT');

insert into korisnik (korisnicko_ime, lozinka, rola_id) values ('admin', 'admin', 1);