drop database film_DB;
create DATABASE film_DB;
use film_DB;

CREATE TABLE Film (
ID INT PRIMARY KEY AUTO_INCREMENT,
Titel VARCHAR(100) NOT NULL,
Lagerort VARCHAR(100) NOT NULL,
Spieldauer INT,
BonusFeatures VARCHAR(100),
Genre VARCHAR(100)
);

INSERT INTO `film` (`ID`, `Titel`, `Lagerort`, `Spieldauer`, `BonusFeatures`, `Genre`)
VALUES
(1, 'Jurassic Park', 'Regal Wohnzimmer', 100, 'Directors Cut', 'Dinosaurier'),
(2, 'Die Ludolfs', 'Wohnzimmerregal', 120, 'Interviews', 'Doku'),
(3, 'Beavis and Butthead - do it in america', 'im Schrank', 90, '-', 'Comic'),
(4, 'Beavis and Butthead - the movie', 'im Schrank', 90, '-', 'Comic'),
(5, 'Star Wars', 'Wohnzimmerschrank', 120, 'making-of', 'science-fiction'),
(6, 'Sharknado', 'Regal Keller', 86, 'Audiokommentar', 'Trash'),
(7, 'Der Schuh des Manitu', 'Regal Wohnzimmer', 87, 'Outtakes', 'Komödie'),
(8, 'Spaceballs', 'Regal Wohnzimmer', 96, 'Behind the Scenes', 'Parodie'),
(9, 'Hot Fuzz', 'im Schrank', 121, 'Deleted Scenes', 'Action-Komödie'),
(10, 'Die nackte Kanone', 'Regal Wohnzimmer', 85, 'Gag Reel', 'Slapstick'),
(11, 'Kung Pow: Enter the Fist', 'Regal Keller', 81, '-', 'Kung-Fu-Komödie'),
(12, 'Team America: World Police', 'Regal Wohnzimmer', 98, 'Musikvideos', 'Satire'),
(13, 'Tucker & Dale vs Evil', 'im Schrank', 89, 'Making-of', 'Horror-Komödie'),
(14, 'Mars Attacks!', 'Regal Wohnzimmer', 106, '-', 'Science-Fiction'),
(15, 'Superbad', 'Regal Schlafzimmer', 113, 'Bloopers', 'Coming-of-Age'),
(16, 'The Room', 'Regal Keller', 99, 'Live Reactions', 'Drama/Trash'),
(17, 'Men in Black', 'Regal Wohnzimmer', 98, 'Alien-Enzyklopädie', 'Science-Fiction'),
(18, 'Zombieland', 'im Schrank', 88, 'Regelbuch', 'Horror-Komödie'),
(19, 'Wayne’s World', 'Regal Wohnzimmer', 94, 'Musik-Featurette', 'Musikkomödie'),
(20, 'Idiocracy', 'Regal Keller', 84, '-', 'Sci-Fi-Satire'),
(21, 'Iron Sky', 'im Schrank', 93, 'Mondbasis-Bauplan', 'Science-Fiction'),
(22, 'Little Britain – Live!', 'Regal Schlafzimmer', 100, 'Live-Audio', 'Sketchshow'),
(23, 'Der Wixxer', 'Regal Wohnzimmer', 82, 'Fan-Kommentare', 'Parodie'),
(24, 'Deadpool', 'Regal Wohnzimmer', 108, 'Uncut', 'Superhelden-Komödie'),
(25, 'Guardians of the Galaxy', 'Regal Wohnzimmer', 121, 'Soundtrack-Session', 'Action-Science-Fiction');