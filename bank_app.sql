-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bank_application
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bank_application
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bank_application` DEFAULT CHARACTER SET latin1 ;
USE `bank_application` ;

-- -----------------------------------------------------
-- Table `bank_application`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank_application`.`customer` (
  `customerID` BIGINT(8) NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(32) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL,
  `lastName` VARCHAR(32) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL,
  `country` VARCHAR(32) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL,
  PRIMARY KEY (`customerID`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_polish_ci;


-- -----------------------------------------------------
-- Table `bank_application`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank_application`.`account` (
  `accountID` BIGINT(8) NOT NULL AUTO_INCREMENT,
  `idOfCustomer` BIGINT(8) NOT NULL,
  `balance` BIGINT(10) NOT NULL,
  `accountNumber` VARCHAR(26) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL,
  `password` VARCHAR(26) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL,
  `admin` TINYINT(1) NULL DEFAULT NULL,
  `username` VARCHAR(26) CHARACTER SET 'utf8' COLLATE 'utf8_polish_ci' NOT NULL,
  PRIMARY KEY (`accountID`),
  UNIQUE INDEX `accountNumber` (`accountNumber` ASC),
  INDEX `customerID` (`idOfCustomer` ASC),
  CONSTRAINT `Account_ibfk_1`
    FOREIGN KEY (`idOfCustomer`)
    REFERENCES `bank_application`.`customer` (`customerID`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 11
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


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
