CREATE TABLE Users(
   user_id CHAR(32) PRIMARY KEY,
   username VARCHAR(32) UNIQUE,
   full_name VARCHAR(32),
   password CHAR(64) NOT NULL,
   age INTEGER NOT NULL,
   sex CHAR(1) NOT NULL,
   city VARCHAR(32) NOT NULL,
   province CHAR(2) NOT NULL
);

CREATE TABLE PostalCode(
  postal_code CHAR(6),
  province CHAR(2) NOT NULL,
  city VARCHAR(60) NOT NULL,
  PRIMARY KEY(postal_code)
);

CREATE TABLE Location(
  location_id CHAR(32),
  name CHAR(128),
  postal_code CHAR(6) NOT NULL,
  street_address VARCHAR(200) NOT NULL,
  PRIMARY KEY(location_id),
  FOREIGN KEY(postal_code) REFERENCES PostalCode(postal_code)
);

CREATE TABLE LocationBooking(
  booking_id CHAR(32) PRIMARY KEY,
  start_time NUMBER(19) NOT NULL,
  end_time NUMBER(19) NOT NULL,
  location_id CHAR(32) NOT NULL,
  FOREIGN KEY(location_id) REFERENCES Location(location_id)
);

CREATE TABLE SportInfo(
  description CHAR(512) PRIMARY KEY,
  meta VARCHAR(512) NOT NULL
);

CREATE TABLE SportDescription(
  name CHAR(32) PRIMARY KEY,
  suggested_number_of_player INTEGER,
  description CHAR(512) NOT NULL,
  FOREIGN KEY(description) REFERENCES SportInfo(description) ON DELETE CASCADE
);

CREATE TABLE Event(
   event_id CHAR(32) PRIMARY KEY,
   name VARCHAR(32) UNIQUE NOT NULL,
   team_size INTEGER,
   is_a_tournament NUMBER(1) NOT NULL,
   number_of_teams INTEGER NOT NULL,
   host_user_id CHAR(32) NOT NULL,
   booking_id CHAR(32) NOT NULL,
   sport char(32) NOT NULL,
   FOREIGN KEY (host_user_id) REFERENCES Users ON DELETE CASCADE,
   FOREIGN KEY (booking_id) REFERENCES LocationBooking ON DELETE CASCADE,
   FOREIGN KEY (sport) REFERENCES SportDescription(name) ON DELETE SET NULL
);

CREATE TABLE Team(
   event_id CHAR(20),
   team_number INTEGER,
   name VARCHAR(32) NOT NULL,
   curr_size INTEGER NOT NULL,
   max_size INTEGER NOT NULL,
   PRIMARY KEY(event_id, team_number),
   FOREIGN KEY (event_id) REFERENCES Event ON DELETE CASCADE
);

CREATE TABLE UserJoins(
  user_id CHAR(32),
  event_id CHAR(32),
  team_number INTEGER,
  PRIMARY KEY(user_id, event_id, team_number),
  FOREIGN KEY(user_id) REFERENCES Users(user_id) ON DELETE CASCADE,
  FOREIGN KEY(event_id) REFERENCES Event(event_id) ON DELETE CASCADE
);

CREATE TABLE Messages(
  message_id CHAR(32),
  sender_user_id CHAR(32) NOT NULL,
  receiver_user_id CHAR(32) NOT NULL,
  content VARCHAR(128) NOT NULL,
  message_timestamp NUMBER(19) NOT NULL,
  PRIMARY KEY(message_id),
  FOREIGN KEY(sender_user_id) REFERENCES Users(user_id) ON DELETE CASCADE,
  FOREIGN KEY(receiver_user_id) REFERENCES Users(user_id) ON DELETE CASCADE
);

CREATE TABLE Invite(
  host_user_id CHAR(32),
  guest_user_id CHAR(32),
  event_id CHAR(32),
  PRIMARY KEY(host_user_id, guest_user_id, event_id),
  FOREIGN KEY(host_user_id) REFERENCES Users(user_id) ON DELETE CASCADE,
  FOREIGN KEY(guest_user_id) REFERENCES Users(user_id) ON DELETE CASCADE,
  FOREIGN KEY(event_id) REFERENCES Event(event_id) ON DELETE CASCADE
);




