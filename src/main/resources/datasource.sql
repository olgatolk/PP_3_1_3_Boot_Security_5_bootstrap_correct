INSERT INTO `roles` (`name`) VALUES ('USER');
INSERT INTO `roles` (`name`) VALUES ('ADMIN');

INSERT INTO `users` (`name`, `age`, `email`, `password`) VALUES ('Patrick', 12,'patrick@mail.com',
                                                 '$2a$12$XW7j6pv8gpk4ea9Wo/cWPusTYpgI03blcLh60Dv5xCm/nBx0q5RTS');
INSERT INTO `users` (`name`, `age`, `email`, `password`) VALUES ('Sim', 22,'sim@mail.com',
                                                  '$2a$12$gMllPjRVcLHz4eMFX6J1we9RqOnL002QF8h6mpwOVyx7EoNYbYD6O');
INSERT INTO `users` (`name`, `age`, `email`, `password`) VALUES ('Dym', 18,'dym@mail.com',
                                                  '$2a$12$oIogwKeJLwx5mG3jvt3mxuh0qPJOeGmMh2/0eoSe.5ZEhcPNfPdJa');

INSERT INTO `user_roles` (`user_email`, `role_name`) VALUES ('sim@mail.com', 'ADMIN');
INSERT INTO `user_roles` (`user_email`, `role_name`) VALUES ('sim@mail.com', 'USER');
INSERT INTO `user_roles` (`user_email`, `role_name`) VALUES ('patrick@mail.com', 'USER');
INSERT INTO `user_roles` (`user_email`, `role_name`) VALUES ('dym@mail.com', 'USER');