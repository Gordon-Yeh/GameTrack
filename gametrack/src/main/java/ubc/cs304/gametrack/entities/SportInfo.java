package ubc.cs304.gametrack.entities;

import java.util.UUID;

public class SportInfo {
    private UUID sport_id; //PK
    private String description;
    private String meta;

    public SportInfo() {
    }

    public SportInfo(UUID sport_id, String description, String meta) {
        this.sport_id = sport_id;
        this.description = description;
        this.meta = meta;
    }

    public UUID getSport_id() {
        return sport_id;
    }

    public void setSport_id(UUID sport_id) {
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
