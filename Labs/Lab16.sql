CREATE TABLE songs (
	id int primary key,
	name varchar(64) not null,
	artist varchar(64) not null,
	album varchar(64) not null,
	genre varchar(64) not null,
	duration decimal,
	fav boolean
);

INSERT INTO songs (id,
					name,
					artist,
					album,
					genre,
					duration,
					fav)
VALUES (1,'Heart-SHaped Box','Nirvana','In Utero','Rock',4.86,false),
(2,'Smells Like Teen Spirit','Nirvana','Nevermind','Rock',3.65,false),
(3,	'Higher','Creed','Human Clay','Rock',5.43,false),
(4,	'Hero','Skillet','Awake','Rock',3.12,false),
(5,	'Hotel California','Eagles','Hotel California','Rock',	3.47,false),
(6,	'Austin',	'Blake Shelton',	'Black Shelton',	'Country',	3.83,	false),
(7,	'Dirt Road Anthem',	'Jason Aldean',	'My Kinda Party',	'Country',	3.81,	false),
(8,	'Springsteen',	'Eric Church',	'Chief',	'Country',	4.38,	false),
(9,	'Watching Airplanes',	'Gary Allen',	'Living Hard',	'Country',	4.05,	false),
(10,	'Hey Girl',	'Billy Currington',	'We Are Tonight',	'Country',	3.35,	false),
(11,	'A Milli',	'Lil Wayne',	'Tha Carter III',	'Hip Hop',	3.70,	false),
(12,	'Over',	'Drake',	'Thank Me Later',	'Hip Hop',	3.90,	false),
(13,	'No Interuption',	'Hoodie Allen',	'All American',	'Hip Hop',	3.58,	false),
(14,	'It Girl',	'Jason Derulo',	'Future History',	'Hip Hop',	3.20,	false),
(15,	'Frick Park Market',	'Mac Miller',	'Blue Slide Park',	'Hip Hop',	3.30,	false);

select * from songs;