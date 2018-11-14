INSERT INTO `bank_application`.`account` 
VALUES 
('1', 10000, '123456789', 'john'),
('2', 120000, '981276345', 'mary'),
('3', 30000, '987654321', 'susan');


--
-- Dumping data for table `users`
--
-- NOTE: The passwords are encrypted using BCrypt

-- A generation tool is avail at: http://www.luv2code.com/generate-bcrypt-password
--
-- Default passwords here are: fun123
--

INSERT INTO `bank_application`.`users` 
VALUES 
('john','{bcrypt}$2a$04$aXW2Sb01tRuTvrhfc5Stx.pHew9comkRDbZuPEkNw16cab3wXDRvq',1),
('mary','{bcrypt}$2a$04$aXW2Sb01tRuTvrhfc5Stx.pHew9comkRDbZuPEkNw16cab3wXDRvq',1),
('susan','{bcrypt}$2a$04$aXW2Sb01tRuTvrhfc5Stx.pHew9comkRDbZuPEkNw16cab3wXDRvq',1);

--
-- Dumping data for table `authorities`
--

INSERT INTO `bank_application`.`authorities` 
VALUES 
('john','ROLE_EMPLOYEE'),
('mary','ROLE_USER'),
('susan','ROLE_EMPLOYEE');

