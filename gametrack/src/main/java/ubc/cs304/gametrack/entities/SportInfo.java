package ubc.cs304.gametrack.entities;

public class SportInfo {
    private String sport_id; //PK
    private String description;
    private String meta;

    public SportInfo() {
    }

    public SportInfo(String sport_id, String description, String meta) {
        this.sport_id = sport_id;
        this.description = description;
        this.meta = meta;
    }

    public String getSport_id() {
        return sport_id;
    }

    public void setSport_id(String sport_id) {
        this.sport_id = sport_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }
}
