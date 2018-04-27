CREATE DATABASE  IF NOT EXISTS `bank_application`;
USE `bank_application`;

-- phpMyAdmin SQL Dump
-- version 4.2.12deb2+deb8u2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Czas generowania: 27 Kwi 2018, 11:16
-- Wersja serwera: 5.5.60-0+deb8u1
-- Wersja PHP: 5.6.33-0+deb8u1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Baza danych: `jglegol1`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `Account`
--

CREATE TABLE IF NOT EXISTS `Account` (
`accountID` bigint(8) NOT NULL,
  `customerID` bigint(8) NOT NULL,
  `balance` bigint(10) NOT NULL,
  `accountNumber` varchar(26) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `Customer`
--

CREATE TABLE IF NOT EXISTS `Customer` (
`customerID` bigint(8) NOT NULL,
  `firstName` varchar(32) COLLATE utf8_polish_ci NOT NULL,
  `lastName` varchar(32) COLLATE utf8_polish_ci NOT NULL,
  `country` varchar(32) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `OrderItem`
--

CREATE TABLE IF NOT EXISTS `OrderItem` (
`orderItemID` bigint(8) NOT NULL,
  `amount` bigint(7) NOT NULL,
  `accountNumberSender` varchar(26) COLLATE utf8_polish_ci NOT NULL,
  `accountNumberReceiver` varchar(26) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `Account`
--
ALTER TABLE `Account`
 ADD PRIMARY KEY (`accountID`), ADD UNIQUE KEY `accountNumber` (`accountNumber`), ADD KEY `customerID` (`customerID`);

--
-- Indexes for table `Customer`
--
ALTER TABLE `Customer`
 ADD PRIMARY KEY (`customerID`);

--
-- Indexes for table `OrderItem`
--
ALTER TABLE `OrderItem`
 ADD PRIMARY KEY (`orderItemID`), ADD KEY `accountNumberSender` (`accountNumberSender`), ADD KEY `accountNumberReceiver` (`accountNumberReceiver`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `Account`
--
ALTER TABLE `Account`
MODIFY `accountID` bigint(8) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `Customer`
--
ALTER TABLE `Customer`
MODIFY `customerID` bigint(8) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `OrderItem`
--
ALTER TABLE `OrderItem`
MODIFY `orderItemID` bigint(8) NOT NULL AUTO_INCREMENT;
--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `Account`
--
ALTER TABLE `Account`
ADD CONSTRAINT `Account_ibfk_1` FOREIGN KEY (`customerID`) REFERENCES `Customer` (`customerID`) ON UPDATE CASCADE;

--
-- Ograniczenia dla tabeli `OrderItem`
--
ALTER TABLE `OrderItem`
ADD CONSTRAINT `OrderItem_ibfk_1` FOREIGN KEY (`accountNumberSender`) REFERENCES `Account` (`accountNumber`) ON UPDATE CASCADE,
ADD CONSTRAINT `OrderItem_ibfk_2` FOREIGN KEY (`accountNumberReceiver`) REFERENCES `Account` (`accountNumber`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
