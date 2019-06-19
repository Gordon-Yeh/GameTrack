

-- Users af93f012-8ef9-11e9-bc42-526af7764f64
INSERT INTO User VALUES ('af93f012-8ef9-11e9-bc42-526af7764f64', 'dario8235', 'Dario Lowery', '123123', 23, 'M', 'Surrey', 'BC');

INSERT INTO User VALUES ('af93f012-8ef9-11e9-bc42-526af7764f65', 'colm_carney2', 'Colm Carney', '123123', 30, 'F', 'Vancouver', 'BC');

INSERT INTO User VALUES ('af93f012-8ef9-11e9-bc42-526af7764f66', 'ricric', 'Rico Browne', '123123', 19, 'M', 'Chilliwack', 'BC');

INSERT INTO User VALUES ('af93f012-8ef9-11e9-bc42-526af7764f67', 'astrid_hum', 'Astrid Humphries', '123123', 42, 'M', 'Vancouver', 'BC');

INSERT INTO User VALUES ('af93f012-8ef9-11e9-bc42-526af7764f68', 'arvbow', 'Arvin Bowen', '123123', 26, 'M', 'Vancouver', 'BC');

INSERT INTO User VALUES ('d4ff40a6-dbdb-47f0-9882-ff979423cf18', 'admin', 'Admin', '123123', 26, 'F', 'Vancouver', 'BC');

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
INSERT INTO Message VALUES ('9cc465ce-8efa-11e9-bc42-526af7764f64', 'af93f012-8ef9-11e9-bc42-526af7764f65', 'af93f012-8ef9-11e9-bc42-526af7764f64', 'hi do you want to meet up and play some ball again?', '1558992568');

INSERT INTO Message VALUES ('9cc465ce-8efa-11e9-bc42-526af7764f65', 'af93f012-8ef9-11e9-bc42-526af7764f65', 'af93f012-8ef9-11e9-bc42-526af7764f66', 'hey where do you want to meet?', '1558992568');

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

-- LocationBooking

INSERT INTO LocationBooking VALUES ('1c32df2e-7ed8-4445-9ba6-5cabe4d86a6e', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
 '9cc46862-8efa-11e9-bc42-526af7764f64');

INSERT INTO LocationBooking VALUES ('2c32df2e-7ed8-4445-9ba6-5cabe4d86a6e', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
 '9cc46861-8efa-11e9-bc42-526af7764f64');

INSERT INTO LocationBooking VALUES ('3c32df2e-7ed8-4445-9ba6-5cabe4d86a6e', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
 '9cc46862-8efa-11e9-bc42-526af7764f64');

INSERT INTO LocationBooking VALUES ('4c32df2e-7ed8-4445-9ba6-5cabe4d86a6e', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
 '9cc46862-8efa-11e9-bc42-526af7764f64');

INSERT INTO LocationBooking VALUES ('5c32df2e-7ed8-4445-9ba6-5cabe4d86a6e', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
 '9cc46858-8efa-11e9-bc42-526af7764f64');

-- -- Event

INSERT INTO Event VALUES ('aec58bf8-e4bb-4ab3-a8e6-5a9c25729935', 'aaa101', 5, false, 2, 
'af93f012-8ef9-11e9-bc42-526af7764f64', '1c32df2e-7ed8-4445-9ba6-5cabe4d86a6e', 'Basketball');

INSERT INTO Event VALUES ('bec58bf8-e4bb-4ab3-a8e6-5a9c25729935', 'aaa102', 6, false, 2, 
'af93f012-8ef9-11e9-bc42-526af7764f64', '2c32df2e-7ed8-4445-9ba6-5cabe4d86a6e', 'Hockey');

INSERT INTO Event VALUES ('cec58bf8-e4bb-4ab3-a8e6-5a9c25729935', 'aaa103', 2, false, 2, 
'af93f012-8ef9-11e9-bc42-526af7764f65', '3c32df2e-7ed8-4445-9ba6-5cabe4d86a6e', 'Tennis');

INSERT INTO Event VALUES ('dec58bf8-e4bb-4ab3-a8e6-5a9c25729935', 'aaa104', 11, true, 4, 
'af93f012-8ef9-11e9-bc42-526af7764f67', '5c32df2e-7ed8-4445-9ba6-5cabe4d86a6e', 'Soccer');

INSERT INTO Event VALUES ('eec58bf8-e4bb-4ab3-a8e6-5a9c25729935', 'aaa105', 5, false, 2, 
'af93f012-8ef9-11e9-bc42-526af7764f66', '4c32df2e-7ed8-4445-9ba6-5cabe4d86a6e', 'Basketball');

-- -- Team

INSERT INTO Team VALUES ('aec58bf8-e4bb-4ab3-a8e6-5a9c25729935', 1, 'Long Live SFU', 1, 5);

INSERT INTO Team VALUES ('aec58bf8-e4bb-4ab3-a8e6-5a9c25729935', 2, 'Make UBC Great Again', 4, 5);

INSERT INTO Team VALUES ('dec58bf8-e4bb-4ab3-a8e6-5a9c25729935', 1, 'Bookstore Boys', 7, 11);

INSERT INTO Team VALUES ('dec58bf8-e4bb-4ab3-a8e6-5a9c25729935', 2, 'Hugh Dempster Devils', 3, 11);

INSERT INTO Team VALUES ('dec58bf8-e4bb-4ab3-a8e6-5a9c25729935', 3, 'Walter Gage Girls', 0, 11);

-- -- Invite

INSERT INTO Invite VALUES ('af93f012-8ef9-11e9-bc42-526af7764f64', 'af93f012-8ef9-11e9-bc42-526af7764f65',
'aec58bf8-e4bb-4ab3-a8e6-5a9c25729935');

INSERT INTO Invite VALUES ('af93f012-8ef9-11e9-bc42-526af7764f64', 'af93f012-8ef9-11e9-bc42-526af7764f66',
'aec58bf8-e4bb-4ab3-a8e6-5a9c25729935');

INSERT INTO Invite VALUES ('af93f012-8ef9-11e9-bc42-526af7764f64', 'af93f012-8ef9-11e9-bc42-526af7764f67',
'aec58bf8-e4bb-4ab3-a8e6-5a9c25729935');

INSERT INTO Invite VALUES ('af93f012-8ef9-11e9-bc42-526af7764f64', 'af93f012-8ef9-11e9-bc42-526af7764f68',
'aec58bf8-e4bb-4ab3-a8e6-5a9c25729935');

INSERT INTO Invite VALUES ('af93f012-8ef9-11e9-bc42-526af7764f67', 'af93f012-8ef9-11e9-bc42-526af7764f64',
'dec58bf8-e4bb-4ab3-a8e6-5a9c25729935');

-- -- UserJoins

INSERT INTO UserJoins VALUES ('af93f012-8ef9-11e9-bc42-526af7764f65',
'aec58bf8-e4bb-4ab3-a8e6-5a9c25729935', 1);

INSERT INTO UserJoins VALUES ('af93f012-8ef9-11e9-bc42-526af7764f66',
'aec58bf8-e4bb-4ab3-a8e6-5a9c25729935', 2);

INSERT INTO UserJoins VALUES ('af93f012-8ef9-11e9-bc42-526af7764f67',
'aec58bf8-e4bb-4ab3-a8e6-5a9c25729935', 1);

INSERT INTO UserJoins VALUES ('af93f012-8ef9-11e9-bc42-526af7764f64',
'dec58bf8-e4bb-4ab3-a8e6-5a9c25729935', 2);

INSERT INTO UserJoins VALUES ('af93f012-8ef9-11e9-bc42-526af7764f68',
'dec58bf8-e4bb-4ab3-a8e6-5a9c25729935', 3);
