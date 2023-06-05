-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Giu 05, 2023 alle 23:15
-- Versione del server: 10.4.27-MariaDB
-- Versione PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `javatestdb`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `appuntamenti`
--

CREATE TABLE `appuntamenti` (
  `id` int(11) NOT NULL,
  `inizio` time NOT NULL,
  `fine` time NOT NULL,
  `data` date NOT NULL,
  `oggetto` text NOT NULL,
  `nome` text NOT NULL,
  `cognome` text NOT NULL,
  `importanza` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `appuntamenti`
--

INSERT INTO `appuntamenti` (`id`, `inizio`, `fine`, `data`, `oggetto`, `nome`, `cognome`, `importanza`) VALUES
(19, '16:00:00', '17:00:00', '2004-03-23', 'ad', 'asd', 'asd', 'Non_Necessario'),
(20, '23:20:00', '20:20:00', '2005-02-20', 'asd', 'asd', 'asd', 'Normale'),
(21, '03:04:00', '05:06:00', '2003-05-15', 'asd', 'asd', 'asd', 'Importantissimo'),
(22, '23:04:00', '04:04:00', '2004-12-30', 'asd', 'asd', 'asd', 'Non_Necessario'),
(23, '02:02:00', '03:03:00', '2005-07-10', 'ad', 'asd', 'asd', 'Normale'),
(24, '20:20:00', '20:20:00', '2004-12-20', 'asd', 'asd', 'asd', 'Normale'),
(25, '20:20:00', '20:20:00', '2004-09-25', 'asd', 'asd', 'asd', 'Normale'),
(26, '20:25:00', '22:00:00', '2005-11-27', 'asd', 'asdasd', 'asd', 'Importantissimo'),
(27, '12:34:00', '21:02:00', '2004-11-17', 'asd', 'asd', 'asd', 'Normale'),
(28, '20:23:00', '23:23:00', '2005-12-11', 'asd', 'asd', 'asd', 'Normale'),
(29, '20:20:00', '20:20:00', '2005-10-23', 'asd', 'asd', 'asd', 'Normale'),
(30, '20:20:00', '20:20:00', '2005-02-23', 'asd', 'sad', 'ad', 'Normale'),
(31, '23:23:00', '23:23:00', '2005-03-20', 'asd', 'sad', 'asd', 'Normale'),
(32, '20:20:00', '20:20:00', '2005-04-12', 'asd', 'asd', 'asd', 'Normale'),
(33, '20:20:00', '20:20:00', '2005-08-12', 'asd', 'asd', 'asd', 'Normale'),
(34, '20:20:00', '20:20:00', '2005-09-12', 'asd', 'asd', 'asd', 'Normale'),
(35, '20:20:00', '20:20:00', '2005-09-23', 'asd', 'asd', 'asd', 'Importantissimo'),
(36, '20:20:00', '20:20:00', '2005-10-15', 'asd', 'asd', 'sad', 'Importantissimo'),
(37, '20:20:00', '20:20:00', '2005-10-05', 'asd', 'ada', 'asd', 'Normale');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `appuntamenti`
--
ALTER TABLE `appuntamenti`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `appuntamenti`
--
ALTER TABLE `appuntamenti`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
