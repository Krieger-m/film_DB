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
(6, 'test', 'testort', 222, 'test feature', 'test'),