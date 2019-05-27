-- Users
INSERT INTO Users VALUES ('11195d1680b611e9bc42526af7764f64', 'dario8235', 'Dario Lowery', '18138372fad4b94533cd4881f03dc6c69296dd897234e0cee83f727e2e6b1f63', 23, 'M', 'Surrey', 'BC');

INSERT INTO Users VALUES ('21195d1680b611e9bc42526af7764f64', 'colm_carney2', 'Colm Carney', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', 30, 'F', 'Vancouver', 'BC');

INSERT INTO Users VALUES ('31195d1680b611e9bc42526af7764f64', 'ricric', 'Rico Browne', '5e7cd28f77173d4f6155f18aa0d3fe2697aa4e2b125e06afdcef35cedbbab8e6', 'M', 19, 'Chilliwack', 'BC');

INSERT INTO Users VALUES ('41195d1680b611e9bc42526af7764f64', 'astrid_hum', 'Astrid Humphries', '9b96378ff78bdc4ccabc3f2f1d7f528e52e07c02ada3517e798bb31b761d835a', 42, 'M', 'Vancouver', 'BC');

INSERT INTO Users VALUES ('51195d1680b611e9bc42526af7764f64', 'arvbow', 'Arvin Bowen', 'afb1975b42c0b05086065ee9320a0f62e261c3b6f901d2bd1454853c3c0a6a85', 26, 'M', 'Vancouver', 'BC');


-- Postal codes
INSERT INTO PostalCode VALUES ('V6T1L9', 'BC', 'Vancouver');

INSERT INTO PostalCode VALUES ('V5H3Z7', 'BC', 'Burnaby');

INSERT INTO PostalCode VALUES ('V5J1A1', 'BC', 'Vancouver');

INSERT INTO PostalCode VALUES ('V6R2J7', 'BC', 'Vancouver');

INSERT INTO PostalCode VALUES ('V6T1X1', 'BC', 'Vancouver');

-- Locations

INSERT INTO Location VALUES ('abc101', 'V6T1L9', 'Kenwoods Soccer Fields', '2205 Wesbrook Mall');

INSERT INTO Location VALUES ('abc102', 'V6T1L9', 'Warren Soccer Fields', '3105 East Mall');

INSERT INTO Location VALUES ('abc103', 'V6T1L9', 'Uhill Soccer Fields', '2195 Wesbrook Mall');

INSERT INTO Location VALUES ('abc104', 'V6R2J7', 'Dunbar Community Centre', '2195 33 Avenue West');

INSERT INTO Location VALUES ('abc105', 'V6T1X1', 'Point Grey Community Centre', '4005 8 Avenue West');

-- Message
INSERT INTO Message VALUES ('4ae6d6198b044c36a228e2c8fd5cbe43', '21195d1680b611e9bc42526af7764f64', '11195d1680b611e9bc42526af7764f64', 'hi do you want to meet up and play some ball again?', '1558992568');

INSERT INTO Message VALUES ('08616377a3e14e6cbd27c65af55660c5', '21195d1680b611e9bc42526af7764f64', '31195d1680b611e9bc42526af7764f64', 'hey where do you want to meet?', '1558992568');

INSERT INTO Message VALUES ('4dab15eae4fd4f229b84ba99d4dc33b7', '41195d1680b611e9bc42526af7764f64', '11195d1680b611e9bc42526af7764f64', 'good game', '1558992568');

INSERT INTO Message VALUES ('6fc4ea67a2cd41ca8ba7d169a2462a4d', '51195d1680b611e9bc42526af7764f64', '41195d1680b611e9bc42526af7764f64', 'nice meeting you', '1558992568');

INSERT INTO Message VALUES ('67a89af1a3d14279805c17b24edefafe', '31195d1680b611e9bc42526af7764f64', '41195d1680b611e9bc42526af7764f64', 'we should play again sometimes', '1558992568');
