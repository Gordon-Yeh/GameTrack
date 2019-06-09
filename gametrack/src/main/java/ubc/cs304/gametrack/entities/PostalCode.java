package ubc.cs304.gametrack.entities;

public class PostalCode {
    private String postal_code;
    private String province;
    private String city;

    public PostalCode() {
    }

    public PostalCode(String postal_code, String province, String city) {
        this.postal_code = postal_code;
        this.province = province;
        this.city = city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
