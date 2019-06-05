package ubc.cs304.gametrack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
public class RegisterController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/register")
    @ResponseBody
    public void registerUser(String username, String full_name, String password, String city, String province, int age, char sex) {

        if (!doesUsernameExist(username)) {
            jdbcTemplate.update(
                    "INSERT INTO Users(userid, username, full_name, password, city, province, age, sex)" +
                            "VALUES (?,?,?,?,?,?,?,?)", UUID.randomUUID(), username, full_name, password, city, province, age, sex);
        } else {
            //username already used, another needs to be selected instead.
        }

    }

    @GetMapping("/login")
    public void login(){

    }

    private boolean doesUsernameExist(String username) {
        String sql = "SELECT count(*) FROM Users WHERE username = ?";
        boolean result = false;

        int count = jdbcTemplate.queryForObject(
                sql, new Object[] { username }, Integer.class);

        if (count > 0) {
            result = true;
        }

        return result;
    }
}
