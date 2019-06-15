package ubc.cs304.gametrack.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ubc.cs304.gametrack.entities.User;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    void createUser(@RequestBody User user) {
        jdbcTemplate.update(
                "INSERT INTO User (user_id, username, full_name, password, city, province, age, sex) VALUES (?,?,?,?,?,?,?,?)",
                UUID.randomUUID().toString(),
                user.getUsername(),
                user.getFull_name(),
                user.getPassword(),
                user.getCity(),
                user.getProvince(),
                user.getAge(),
                user.getSex());
    }
    
    List<User> findAllUsers() {
        return jdbcTemplate.query("SELECT user_id, username, full_name, password, city, province, age, sex FROM User;",
                new BeanPropertyRowMapper<User>(User.class));
    }

    User findUserBy(String username) {
         List<User> users = findAllUsers();
         return users.stream().filter(u -> u.getUsername().equals(username)).findFirst().orElse(new User());
    }
}
