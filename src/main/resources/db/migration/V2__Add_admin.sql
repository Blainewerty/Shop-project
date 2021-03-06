insert into usr (login, password, active)
values ('admin', '$2a$10$ikvfZ/9mOxMT0jb2MTD7WuOT53RdsUljz6IoirbLxkFkrZyPdvNu.', true);
insert into roles(user_id, roles)
values (1, 'USER'),(1,'ADMIN')