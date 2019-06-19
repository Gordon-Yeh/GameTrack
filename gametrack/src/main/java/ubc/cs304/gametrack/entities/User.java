package ubc.cs304.gametrack.entities;

import java.util.UUID;
import ubc.cs304.gametrack.entities.SecuredUser;

public class User extends SecuredUser {
    private String password;

    public User() {
        super();
    }

    public User(UUID user_id, String username, String full_name, String password, String city, String province, int age, String sex) {
        super(user_id, username, full_name, city, province, age, sex);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
