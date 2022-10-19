insert into state(name) values('in process');
insert into category(name) values('products');
insert into roles(name) values('Admin');
insert into rules(name) values('No chattin');
insert into roles_rules(rules_id, roles_id) values(1, 1);
insert into users(name, roles_id) values('Unknown', 1);
insert into item(user_id, category_id, state_id) values(1, 1, 1);
insert into comments(name, item_id) values('post', 1);
insert into attachs(name, item_id) values('video', 1);
