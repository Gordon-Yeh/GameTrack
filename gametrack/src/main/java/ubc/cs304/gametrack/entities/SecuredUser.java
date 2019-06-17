package ubc.cs304.gametrack.entities;

import java.util.UUID;

public class SecuredUser {
    private UUID user_id;

    private String username, full_name, city, province;

    private int age;

    private String sex;

    public SecuredUser() {
    }

    public SecuredUser(UUID user_id, String username, String full_name, String city, String province, int age, String sex) {
        this.user_id = user_id;
        this.username = username;
        this.full_name = full_name;
        this.city = city;
        this.province = province;
        this.age = age;
        this.sex = sex;
    }

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
