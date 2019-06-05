package ubc.cs304.gametrack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class GametrackApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(GametrackApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(GametrackApplication.class, args);
    }

    
    @Autowired
    JdbcTemplate jdbcTemplate;

    /* Example code from https://spring.io/guides/gs/relational-data-access/ */
    @Override
    public void run(String... strings) throws Exception {

        log.info("Initializing...");

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS Users(" +
                "user_id CHAR(32) PRIMARY KEY," +
                "username VARCHAR(32) UNIQUE," +
                "full_name VARCHAR(32)," +
                "password CHAR(64) NOT NULL," +
                "age INTEGER NOT NULL," +
                "sex CHAR(1) NOT NULL," +
                "city VARCHAR(32) NOT NULL," +
                "province CHAR(2) NOT NULL" +
                ");" +
                "" +
                "CREATE TABLE IF NOT EXISTS PostalCode(" +
                "postal_code CHAR(6)," +
                "province CHAR(2) NOT NULL," +
                "city VARCHAR(60) NOT NULL," +
                "PRIMARY KEY(postal_code)" +
                ");" +
                "" +
                "CREATE TABLE IF NOT EXISTS Location(" +
                "location_id CHAR(32)," +
                "name CHAR(128)," +
                "postal_code CHAR(6) NOT NULL," +
                "street_address VARCHAR(200) NOT NULL," +
                "PRIMARY KEY(location_id)," +
                "FOREIGN KEY(postal_code) REFERENCES PostalCode(postal_code)" +
                ");" +
                "" +
                "CREATE TABLE IF NOT EXISTS LocationBooking(" +
                "booking_id CHAR(32) PRIMARY KEY," +
                "start_time NUMBER(19) NOT NULL," +
                "end_time NUMBER(19) NOT NULL," +
                "location_id CHAR(32) NOT NULL," +
                "FOREIGN KEY(location_id) REFERENCES Location(location_id)" +
                ");" +
                "" +
                "CREATE TABLE IF NOT EXISTS SportInfo(" +
                "description CHAR(512) PRIMARY KEY," +
                "meta VARCHAR(512) NOT NULL" +
                ");" +
                "" +
                "CREATE TABLE IF NOT EXISTS SportDescription(" +
                "name CHAR(32) PRIMARY KEY," +
                "suggested_number_of_player INTEGER," +
                "description CHAR(512) NOT NULL," +
                "FOREIGN KEY(description) REFERENCES SportInfo(description) ON DELETE CASCADE" +
                ");" +
                "" +
                "CREATE TABLE IF NOT EXISTS Event(" +
                "event_id CHAR(32) PRIMARY KEY," +
                "name VARCHAR(32) UNIQUE NOT NULL," +
                "team_size INTEGER," +
                "is_a_tournament NUMBER(1) NOT NULL," +
                "number_of_teams INTEGER NOT NULL," +
                "host_user_id CHAR(32) NOT NULL," +
                "booking_id CHAR(32) NOT NULL," +
                "sport char(32) NOT NULL," +
                "FOREIGN KEY (host_user_id) REFERENCES Users ON DELETE CASCADE," +
                "FOREIGN KEY (booking_id) REFERENCES LocationBooking ON DELETE CASCADE," +
                "FOREIGN KEY (sport) REFERENCES SportDescription(name) ON DELETE SET NULL" +
                ");" +
                "" +
                "CREATE TABLE IF NOT EXISTS Team(" +
                "event_id CHAR(20)," +
                "team_number INTEGER PRIMARY KEY," +
                "name VARCHAR(32) NOT NULL," +
                "curr_size INTEGER NOT NULL," +
                "max_size INTEGER NOT NULL," +
                "FOREIGN KEY (event_id) REFERENCES Event ON DELETE CASCADE" +
                ");" +
                "" +
                "CREATE TABLE IF NOT EXISTS UserJoins(" +
                "user_id CHAR(32)," +
                "event_id CHAR(32)," +
                "team_number INTEGER," +
                "PRIMARY KEY(user_id, event_id, team_number)," +
                "FOREIGN KEY(user_id) REFERENCES Users(user_id) ON DELETE CASCADE," +
                "FOREIGN KEY(event_id) REFERENCES Event(event_id) ON DELETE CASCADE" +
                ");" +
                "" +
                "CREATE TABLE IF NOT EXISTS Messages(" +
                "message_id CHAR(32)," +
                "sender_user_id CHAR(32) NOT NULL," +
                "receiver_user_id CHAR(32) NOT NULL," +
                "content VARCHAR(128) NOT NULL," +
                "message_timestamp NUMBER(19) NOT NULL," +
                "PRIMARY KEY(message_id)," +
                "FOREIGN KEY(sender_user_id) REFERENCES Users(user_id) ON DELETE CASCADE," +
                "FOREIGN KEY(receiver_user_id) REFERENCES Users(user_id) ON DELETE CASCADE" +
                ");" +
                "" +
                "CREATE TABLE IF NOT EXISTS Invite(" +
                "host_user_id CHAR(32)," +
                "guest_user_id CHAR(32)," +
                "event_id CHAR(32)," +
                "PRIMARY KEY(host_user_id, guest_user_id, event_id)," +
                "FOREIGN KEY(host_user_id) REFERENCES Users(user_id) ON DELETE CASCADE," +
                "FOREIGN KEY(guest_user_id) REFERENCES Users(user_id) ON DELETE CASCADE," +
                "FOREIGN KEY(event_id) REFERENCES Event(event_id) ON DELETE CASCADE" +
                ");");




//        jdbcTemplate.execute("DROP TABLE IF EXISTS customers");
//        jdbcTemplate.execute("CREATE TABLE customers(" +
//                "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");
//
//        // Split up the array of whole names into an array of first/last names
//        List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
//                .map(name -> name.split(" "))
//                .collect(Collectors.toList());
//
//        // Use a Java 8 stream to print out each tuple of the list
//        splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));
//
//        // Uses JdbcTemplate's batchUpdate operation to bulk load data
//        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);
//
//        log.info("Querying for customer records where first_name = 'Josh':");
//        jdbcTemplate.query(
//                "SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[] { "Josh" },
//                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
//        ).forEach(customer -> log.info(customer.toString()));
//
//    }
    }
}
