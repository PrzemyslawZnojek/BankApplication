CREATE SCHEMA IF NOT EXISTS `bank_application` DEFAULT CHARACTER SET latin1 ;
USE `bank_application` ;

-- -----------------------------------------------------
-- Table `bank_application`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank_application`.`account` (
  `accountID` BIGINT(8) NOT NULL AUTO_INCREMENT,
  `balance` BIGINT(10) NOT NULL,
  `accountNumber` VARCHAR(26) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL,
  `username` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL,
  PRIMARY KEY (`accountID`),
  UNIQUE INDEX `accountNumber` (`accountNumber` ASC),
  UNIQUE (`username`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci;

-- -----------------------------------------------------
-- Table `bank_application`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank_application`.`customer` (
  `customerID` BIGINT(8) NOT NULL AUTO_INCREMENT,
  `idOfAccount` BIGINT(8) NOT NULL,
  `firstName` VARCHAR(32) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL,
  `lastName` VARCHAR(32) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL,
  `country` VARCHAR(32) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL,
  PRIMARY KEY (`customerID`),
  FOREIGN KEY (`idOfAccount`) REFERENCES `bank_application`.`account` (`accountID`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci;

CREATE TABLE IF NOT EXISTS `bank_application`.`users` (
  `username` varchar(50)  CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL,
  `password` varchar(68) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`),  
  CONSTRAINT `Users_ibfk_1` 
    FOREIGN KEY (`username`) 
    REFERENCES `bank_application`.`account` (`username`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci;




-- -----------------------------------------------------
-- Table `bank_application`.`orderitem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank_application`.`orderitem` (
  `orderItemID` BIGINT(8) NOT NULL AUTO_INCREMENT,
  `amount` BIGINT(7) NOT NULL,
  `accountNumberSender` VARCHAR(26) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL,
  `accountNumberReceiver` VARCHAR(26) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL,
  PRIMARY KEY (`orderItemID`),
  INDEX `accountNumberSender` (`accountNumberSender` ASC),
  INDEX `accountNumberReceiver` (`accountNumberReceiver` ASC),
  CONSTRAINT `OrderItem_ibfk_1`
    FOREIGN KEY (`accountNumberSender`)
    REFERENCES `bank_application`.`account` (`accountNumber`)
    ON UPDATE CASCADE,
  CONSTRAINT `OrderItem_ibfk_2`
    FOREIGN KEY (`accountNumberReceiver`)
    REFERENCES `bank_application`.`account` (`accountNumber`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci;

CREATE TABLE IF NOT EXISTS `bank_application`.`authorities` (
  `username` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `bank_application`.`users` (`username`)
) ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci;
