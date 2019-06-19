

-- Users af93f012-8ef9-11e9-bc42-526af7764f64
INSERT INTO User VALUES ('2563eb25-b7ac-40d7-a28f-810694046382', 'admin', 'Bob Rosh', 'admin', 23, 'M', 'Surrey', 'BC');

INSERT INTO User VALUES ('af93f012-8ef9-11e9-bc42-526af7764f64', 'dario8235', 'Dario Lowery', '18138372fad4b94533cd4881f03dc6c69296dd897234e0cee83f727e2e6b1f63', 23, 'M', 'Surrey', 'BC');

INSERT INTO User VALUES ('af93f012-8ef9-11e9-bc42-436af7764f64', 'colm_carney2', 'Colm Carney', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', 30, 'F', 'Vancouver', 'BC');

INSERT INTO User VALUES ('af93f012-8ef9-11e9-bc42-526af7764f66', 'ricric', 'Rico Browne', '5e7cd28f77173d4f6155f18aa0d3fe2697aa4e2b125e06afdcef35cedbbab8e6', 19, 'M', 'Chilliwack', 'BC');

INSERT INTO User VALUES ('af93f012-8ef9-11e9-bc42-526af7764f67', 'astrid_hum', 'Astrid Humphries', '9b96378ff78bdc4ccabc3f2f1d7f528e52e07c02ada3517e798bb31b761d835a', 42, 'M', 'Vancouver', 'BC');

INSERT INTO User VALUES ('af93f012-8ef9-11e9-bc42-526af7764f68', 'arvbow', 'Arvin Bowen', 'afb1975b42c0b05086065ee9320a0f62e261c3b6f901d2bd1454853c3c0a6a85', 26, 'M', 'Vancouver', 'BC');

-- Postal codes
INSERT INTO PostalCode VALUES ('V6T1L9', 'BC', 'Vancouver');

INSERT INTO PostalCode VALUES ('V5H3Z7', 'BC', 'Burnaby');

INSERT INTO PostalCode VALUES ('V5J1A1', 'BC', 'Vancouver');

INSERT INTO PostalCode VALUES ('V6R2J7', 'BC', 'Vancouver');

INSERT INTO PostalCode VALUES ('V6T1X1', 'BC', 'Vancouver');

-- Locations

INSERT INTO Location VALUES ('9cc46858-8efa-11e9-bc42-526af7764f64',  'Kenwoods Soccer Fields','V6T1L9', '2205 Wesbrook Mall');

INSERT INTO Location VALUES ('9cc46859-8efa-11e9-bc42-526af7764f64', 'Warren Soccer Fields', 'V6T1L9',  '3105 East Mall');

INSERT INTO Location VALUES ('9cc46860-8efa-11e9-bc42-526af7764f64', 'Uhill Soccer Fields', 'V6T1L9',  '2195 Wesbrook Mall');

INSERT INTO Location VALUES ('9cc46861-8efa-11e9-bc42-526af7764f64', 'Dunbar Community Centre', 'V6R2J7',  '2195 33 Avenue West');

INSERT INTO Location VALUES ('9cc46862-8efa-11e9-bc42-526af7764f64', 'Point Grey Community Centre', 'V6T1X1', '4005 8 Avenue West');

-- Message
INSERT INTO Message VALUES ('9cc465ce-8efa-11e9-bc42-526af7764f64', 'af93f012-8ef9-11e9-bc42-436af7764f64', 'af93f012-8ef9-11e9-bc42-526af7764f64', 'hi do you want to meet up and play some ball again?', '1558992568');

INSERT INTO Message VALUES ('9cc465ce-8efa-11e9-bc42-526af7764f65', 'af93f012-8ef9-11e9-bc42-436af7764f64', 'af93f012-8ef9-11e9-bc42-526af7764f66', 'hey where do you want to meet?', '1558992568');

INSERT INTO Message VALUES ('9cc465ce-8efa-11e9-bc42-526af7764f66', 'af93f012-8ef9-11e9-bc42-526af7764f67', 'af93f012-8ef9-11e9-bc42-526af7764f64', 'good game', '1558992568');

INSERT INTO Message VALUES ('9cc465ce-8efa-11e9-bc42-526af7764f67', 'af93f012-8ef9-11e9-bc42-526af7764f68', 'af93f012-8ef9-11e9-bc42-526af7764f67', 'nice meeting you', '1558992568');

INSERT INTO Message VALUES ('9cc465ce-8efa-11e9-bc42-526af7764f68', 'af93f012-8ef9-11e9-bc42-526af7764f66', 'af93f012-8ef9-11e9-bc42-526af7764f67', 'we should play again sometimes', '1558992568');

-- SportInfo 

INSERT INTO SportInfo VALUES (
    'The game of tennis.',
    'number_of_rounds: 3, expected_game_duration: 180',
   	'Nothing more.');

INSERT INTO SportInfo VALUES (
    'The game of soccer.',
    'expected_game_duration: 150',
    'Nothing more.'
);

INSERT INTO SportInfo VALUES (
    'The game of basketball.', 
    'number_of_rounds: 2, expected_game_duration: 150',
   	'Nothing more.'
);

INSERT INTO SportInfo VALUES (
    'The game of hockey.',
    'number_of_rounds: 3, expected_game_duration: 150',
   	'Nothing more.'
);

INSERT INTO SportInfo VALUES (
    'The game of baseball.',
    'number_of_rounds: 9, expected_game_duration: 210',
   	'Nothing more.'
);

-- SportDescription

INSERT INTO SportDescription(name, suggested_number_of_player, sport_id) VALUES (
    'Tennis',
    2,
    'The game of tennis.');

INSERT INTO SportDescription(name, suggested_number_of_player, sport_id) VALUES (
    'Soccer',
    11,
    'The game of soccer.'
);

INSERT INTO SportDescription(name, suggested_number_of_player, sport_id) VALUES (
    'Basketball',
    5,
    'The game of basketball.'
);

INSERT INTO SportDescription(name, suggested_number_of_player, sport_id) VALUES (
    'Hockey',
    6,
    'The game of hockey.'
);

INSERT INTO SportDescription(name, suggested_number_of_player, sport_id) VALUES (
    'Baseball',
    9,
    'The game of baseball.'
);