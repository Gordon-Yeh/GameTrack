package ubc.cs304.gametrack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class GametrackApplication {

    private static final Logger log = LoggerFactory.getLogger(GametrackApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(GametrackApplication.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

//    @Override
//    public void run(String... strings) throws Exception {
//
//        Connection con = DriverManager.getConnection(
//                "jdbc:oracle:thin:@dbhost.students.cs.ubc.ca:1522:stu", System.getenv("ORA_USERNAME"), System.getenv("ORA_PASSWORD"));
//
//
//    }
}
