package ubc.cs304.gametrack.entities;

public class PostalCode {
    private String postal_code;
    private String province;
    private String city;

    public PostalCode(String postal_code, String province, String city) {
        this.postal_code = postal_code;
        this.province = province;
        this.city = city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }
}
