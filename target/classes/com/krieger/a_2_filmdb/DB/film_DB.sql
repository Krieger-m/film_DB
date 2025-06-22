-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 23. Jun 2025 um 00:15
-- Server-Version: 10.4.32-MariaDB
-- PHP-Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `film_db`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `film`
--

DROP TABLE IF EXISTS `film`;
CREATE TABLE `film` (
  `ID` int(11) NOT NULL,
  `Titel` varchar(100) NOT NULL,
  `Lagerort` varchar(100) NOT NULL,
  `Spieldauer` int(11) DEFAULT NULL,
  `BonusFeatures` varchar(100) DEFAULT NULL,
  `Genre` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `film`
--

INSERT INTO `film` (`ID`, `Titel`, `Lagerort`, `Spieldauer`, `BonusFeatures`, `Genre`) VALUES
(1, 'Jurassic Park', 'Regal Wohnzimmer', 100, 'Directors Cut', 'Dinosaurier'),
(2, 'Die Ludolfs', 'Wohnzimmerregal', 120, 'Interviews', 'Doku'),
(3, 'Beavis and Butthead - do it in america', 'im Schrank', 90, '-', 'Comic'),
(4, 'Beavis and Butthead - the movie', 'im Schrank', 90, '-', 'Comic'),
(5, 'Star Wars', 'Wohnzimmerschrank', 120, 'making-of', 'science-fiction'),
(6, 'Sharknado', 'Regal Keller', 86, 'Audiokommentar', 'Trash'),
(7, 'Kung-Fury - ', 'Regal Wohnzimmer', 87, 'Outtakes', 'Komödie'),
(8, 'Spaceballs', 'Regal Wohnzimmer', 96, 'Behind the Scenes', 'Parodie'),
(9, 'Hot Fuzz', 'im Schrank', 121, 'Deleted Scenes', 'Action-Komödie'),
(10, 'Die nackte Kanone', 'Regal Wohnzimmer', 85, 'Gag Reel', 'Slapstick'),
(11, 'Idiocracy', 'Regal Keller', 81, '-', 'Satire'),
(12, 'Team America: World Police', 'Regal Wohnzimmer', 98, 'Musikvideos', 'Satire'),
(13, 'Tucker & Dale vs Evil', 'im Schrank', 89, 'Making-of', 'Horror-Komödie'),
(14, 'Mars Attacks!', 'Regal Wohnzimmer', 106, '-', 'Science-Fiction'),
(15, 'Superbad', 'Regal Schlafzimmer', 113, 'Bloopers', 'Coming-of-Age'),
(16, 'The Room', 'Regal Keller', 99, 'Live Reactions', 'Drama/Trash'),
(17, 'The life of Brian', 'Regal Wohnzimmer', 98, 'Bibel-Kapitel', 'Science-Fiction-Kommödie'),
(18, 'Zombieland', 'im Schrank', 88, 'Regelbuch', 'Horror-Komödie'),
(19, 'Wayne’s World', 'Regal Wohnzimmer', 94, 'Musik-Featurette', 'Musikkomödie'),
(20, 'Idiocracy', 'Regal Keller', 84, '-', 'Sci-Fi-Satire'),
(21, 'Iron Sky', 'im Schrank', 93, 'Mondbasis-Bauplan', 'Science-Fiction'),
(22, 'Little Britain – Live!', 'Regal Schlafzimmer', 100, 'Live-Audio', 'Sketchshow'),
(23, 'Der Wixxer', 'Regal Wohnzimmer', 82, 'Fan-Kommentare', 'Parodie');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `film`
--
ALTER TABLE `film`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
