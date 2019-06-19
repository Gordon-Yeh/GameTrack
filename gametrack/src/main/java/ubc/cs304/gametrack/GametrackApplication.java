package ubc.cs304.gametrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GametrackApplication implements CommandLineRunner {
public class GametrackApplication {

    private static final Logger log = LoggerFactory.getLogger(GametrackApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(GametrackApplication.class, args);
    }

    /* I had issues with creating tables from here, so I just initialized them with SQuirreL.
    *  Go ahead and add the execute statement here if you can get it working.*/


    @Autowired
    JdbcTemplate jdbcTemplate;
//
//    /* Example code from https://spring.io/guides/gs/relational-data-access/ */
    @Override
    public void run(String... strings) throws Exception {
        log.info("Initializing...");

   /* jdbcTemplate.execute("DROP TABLE IF EXISTS Users");
    jdbcTemplate.execute("DROP TABLE IF EXISTS LocationBooking");
    jdbcTemplate.execute("DROP TABLE IF EXISTS Event");
    jdbcTemplate.execute("DROP TABLE IF EXISTS Invite");
    jdbcTemplate.execute("DROP TABLE IF EXISTS Location");
    jdbcTemplate.execute("DROP TABLE IF EXISTS Message");
    jdbcTemplate.execute("DROP TABLE IF EXISTS PostalCode");
    jdbcTemplate.execute("DROP TABLE IF EXISTS SportsDescription");
    jdbcTemplate.execute("DROP TABLE IF EXISTS SportsInfo");
    jdbcTemplate.execute("DROP TABLE IF EXISTS Team");
    jdbcTemplate.execute("DROP TABLE IF EXISTS UserJoins"); */ 
        
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS LocationBooking(" +
                "booking_id VARCHAR(255), start_time Timestamp, end_time Timestamp, location_id VARCHAR(255)");

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS Event(" +
                "event_id VARCHAR(255), name VARCHAR(32), team_size INTEGER, is_a_tournament BOOLEAN," +
                "number_of_teams INTEGER, host_user_id VARCHAR(255), ");

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS Invite(" +
                "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS Location(" +
                "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS Message(" +
                "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS PostalCode(" +
                "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS SportsDescription(" +
                "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS SportsInfo(" +
                "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS Team(" +
                "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS Users(" +
                "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS UserJoins(" +
                "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");
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
//    }
}
