
USE `bank_application`;

INSERT INTO `users` 
VALUES 
('john','{noop}test123',1),
('susan','{noop}test123',1);


INSERT INTO `authorities` 
VALUES 
('john','ROLE_USER'),
('susan','ROLE_EMPLOYEE');


