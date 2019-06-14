CREATE TABLE User(
   user_id VARCHAR(255) PRIMARY KEY,
   username VARCHAR(80) UNIQUE,
   full_name VARCHAR(255),
   password CHAR(64) NOT NULL,
   age INTEGER NOT NULL,
   sex CHAR(1) NOT NULL,
   city VARCHAR(80) NOT NULL,
   province CHAR(2) NOT NULL
);

CREATE TABLE PostalCode(
  postal_code CHAR(6),
  province CHAR(2) NOT NULL,
  city VARCHAR(60) NOT NULL,
  PRIMARY KEY(postal_code)
);

CREATE TABLE Location(
  location_id VARCHAR(255),
  name CHAR(128),
  postal_code CHAR(6) NOT NULL,
  street_address VARCHAR(200) NOT NULL,
  PRIMARY KEY(location_id),
  FOREIGN KEY(postal_code) REFERENCES PostalCode(postal_code)
);

CREATE TABLE LocationBooking(
  booking_id VARCHAR(255) PRIMARY KEY,
  start_time TIMESTAMP NOT NULL,
  end_time TIMESTAMP NOT NULL,
  location_id VARCHAR(255) NOT NULL,
  FOREIGN KEY(location_id) REFERENCES Location(location_id)
);

CREATE TABLE SportInfo(
  sport_id VARCHAR(255) PRIMARY KEY,
  description TEXT,
  meta TEXT NOT NULL
);

CREATE TABLE SportDescription(
  name CHAR(32) PRIMARY KEY,
  suggested_number_of_player INTEGER,
  sport_id VARCHAR(255) NOT NULL,
  FOREIGN KEY(sport_id) REFERENCES SportInfo(sport_id) ON DELETE CASCADE
);

CREATE TABLE Event(
   event_id VARCHAR(255) PRIMARY KEY,
   name VARCHAR(32) UNIQUE NOT NULL,
   team_size INTEGER,
   is_a_tournament BOOLEAN NOT NULL,
   number_of_teams INTEGER NOT NULL,
   host_user_id VARCHAR(255) NOT NULL,
   booking_id VARCHAR(255) NOT NULL,
   sport char(32),
   FOREIGN KEY (host_user_id) REFERENCES User(user_id) ON DELETE CASCADE,
   FOREIGN KEY (booking_id) REFERENCES LocationBooking(booking_id) ON DELETE CASCADE,
   FOREIGN KEY (sport) REFERENCES SportDescription(name) ON DELETE SET NULL
);

CREATE TABLE Team(
   event_id VARCHAR(255),
   team_number INTEGER,
   name VARCHAR(32) NOT NULL,
   curr_size INTEGER NOT NULL,
   max_size INTEGER NOT NULL,
   PRIMARY KEY(event_id, team_number),
   FOREIGN KEY (event_id) REFERENCES Event(event_id) ON DELETE CASCADE
);

CREATE TABLE UserJoins(
  user_id VARCHAR(255),
  event_id VARCHAR(255),
  team_number INTEGER,
  PRIMARY KEY(user_id, event_id, team_number),
  FOREIGN KEY(user_id) REFERENCES User(user_id) ON DELETE CASCADE,
  FOREIGN KEY(event_id) REFERENCES Event(event_id) ON DELETE CASCADE
);

CREATE TABLE Message(
  message_id VARCHAR(255),
  sender_user_id VARCHAR(255) NOT NULL,
  receiver_user_id VARCHAR(255) NOT NULL,
  content VARCHAR(128) NOT NULL,
  message_timestamp BIGINT NOT NULL,
  PRIMARY KEY(message_id),
  FOREIGN KEY(sender_user_id) REFERENCES User(user_id) ON DELETE CASCADE,
  FOREIGN KEY(receiver_user_id) REFERENCES User(user_id) ON DELETE CASCADE
);

CREATE TABLE Invite(
  host_user_id VARCHAR(255),
  guest_user_id VARCHAR(255),
  event_id VARCHAR(255),
  PRIMARY KEY(host_user_id, guest_user_id, event_id),
  FOREIGN KEY(host_user_id) REFERENCES User(user_id) ON DELETE CASCADE,
  FOREIGN KEY(guest_user_id) REFERENCES User(user_id) ON DELETE CASCADE,
  FOREIGN KEY(event_id) REFERENCES Event(event_id) ON DELETE CASCADE
);