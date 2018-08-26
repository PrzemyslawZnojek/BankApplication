--
-- password is: test123
--

UPDATE `bank_application`.`users`
SET password = '{bcrypt}$2a$04$aXW2Sb01tRuTvrhfc5Stx.pHew9comkRDbZuPEkNw16cab3wXDRvq'
WHERE username = 'john';