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
    
    public void setupJDBC() {
    	
    }
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    /* Example code from https://spring.io/guides/gs/relational-data-access/ */
    @Override
    public void run(String... strings) throws Exception {

        log.info("Initializing...");

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS Users(\n" +
                "user_id CHAR(32) PRIMARY KEY,\n" +
                "username VARCHAR(32) UNIQUE,\n" +
                "full_name VARCHAR(32),\n" +
                "password CHAR(64) NOT NULL,\n" +
                "age INTEGER NOT NULL,\n" +
                "sex CHAR(1) NOT NULL,\n" +
                "city VARCHAR(32) NOT NULL,\n" +
                "province CHAR(2) NOT NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE IF NOT EXISTS PostalCode(\n" +
                "postal_code CHAR(6),\n" +
                "province CHAR(2) NOT NULL,\n" +
                "city VARCHAR(60) NOT NULL,\n" +
                "PRIMARY KEY(postal_code)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE IF NOT EXISTS Location(\n" +
                "location_id CHAR(32),\n" +
                "name CHAR(128),\n" +
                "postal_code CHAR(6) NOT NULL,\n" +
                "street_address VARCHAR(200) NOT NULL,\n" +
                "PRIMARY KEY(location_id),\n" +
                "FOREIGN KEY(postal_code) REFERENCES PostalCode(postal_code)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE IF NOT EXISTS LocationBooking(\n" +
                "booking_id CHAR(32) PRIMARY KEY,\n" +
                "start_time NUMBER(19) NOT NULL,\n" +
                "end_time NUMBER(19) NOT NULL,\n" +
                "location_id CHAR(32) NOT NULL,\n" +
                "FOREIGN KEY(location_id) REFERENCES Location(location_id)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE IF NOT EXISTS SportInfo(\n" +
                "description CHAR(512) PRIMARY KEY,\n" +
                "meta VARCHAR(512) NOT NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE IF NOT EXISTS SportDescription(\n" +
                "name CHAR(32) PRIMARY KEY,\n" +
                "suggested_number_of_player INTEGER,\n" +
                "description CHAR(512) NOT NULL,\n" +
                "FOREIGN KEY(description) REFERENCES SportInfo(description) ON DELETE CASCADE\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE IF NOT EXISTS Event(\n" +
                "event_id CHAR(32) PRIMARY KEY,\n" +
                "name VARCHAR(32) UNIQUE NOT NULL,\n" +
                "team_size INTEGER,\n" +
                "is_a_tournament NUMBER(1) NOT NULL,\n" +
                "number_of_teams INTEGER NOT NULL,\n" +
                "host_user_id CHAR(32) NOT NULL,\n" +
                "booking_id CHAR(32) NOT NULL,\n" +
                "sport char(32) NOT NULL,\n" +
                "FOREIGN KEY (host_user_id) REFERENCES Users ON DELETE CASCADE,\n" +
                "FOREIGN KEY (booking_id) REFERENCES LocationBooking ON DELETE CASCADE,\n" +
                "FOREIGN KEY (sport) REFERENCES SportDescription(name) ON DELETE SET NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE IF NOT EXISTS Team(\n" +
                "event_id CHAR(20),\n" +
                "team_number INTEGER PRIMARY KEY,\n" +
                "name VARCHAR(32) NOT NULL,\n" +
                "curr_size INTEGER NOT NULL,\n" +
                "max_size INTEGER NOT NULL,\n" +
                "FOREIGN KEY (event_id) REFERENCES Event ON DELETE CASCADE\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE IF NOT EXISTS UserJoins(\n" +
                "user_id CHAR(32),\n" +
                "event_id CHAR(32),\n" +
                "team_number INTEGER,\n" +
                "PRIMARY KEY(user_id, event_id, team_number),\n" +
                "FOREIGN KEY(user_id) REFERENCES Users(user_id) ON DELETE CASCADE,\n" +
                "FOREIGN KEY(event_id) REFERENCES Event(event_id) ON DELETE CASCADE\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE IF NOT EXISTS Messages(\n" +
                "message_id CHAR(32),\n" +
                "sender_user_id CHAR(32) NOT NULL,\n" +
                "receiver_user_id CHAR(32) NOT NULL,\n" +
                "content VARCHAR(128) NOT NULL,\n" +
                "message_timestamp NUMBER(19) NOT NULL,\n" +
                "PRIMARY KEY(message_id),\n" +
                "FOREIGN KEY(sender_user_id) REFERENCES Users(user_id) ON DELETE CASCADE,\n" +
                "FOREIGN KEY(receiver_user_id) REFERENCES Users(user_id) ON DELETE CASCADE\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE IF NOT EXISTS Invite(\n" +
                "host_user_id CHAR(32),\n" +
                "guest_user_id CHAR(32),\n" +
                "event_id CHAR(32),\n" +
                "PRIMARY KEY(host_user_id, guest_user_id, event_id),\n" +
                "FOREIGN KEY(host_user_id) REFERENCES Users(user_id) ON DELETE CASCADE,\n" +
                "FOREIGN KEY(guest_user_id) REFERENCES Users(user_id) ON DELETE CASCADE,\n" +
                "FOREIGN KEY(event_id) REFERENCES Event(event_id) ON DELETE CASCADE\n" +
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
    
//    public class Customer {
//        private long id;
//        private String firstName, lastName;
//
//        public Customer(long id, String firstName, String lastName) {
//            this.id = id;
//            this.firstName = firstName;
//            this.lastName = lastName;
//        }
//
//        @Override
//        public String toString() {
//            return String.format(
//                    "Customer[id=%d, firstName='%s', lastName='%s']",
//                    id, firstName, lastName);
//        }
//
//        // getters & setters omitted for brevity
    }
}
