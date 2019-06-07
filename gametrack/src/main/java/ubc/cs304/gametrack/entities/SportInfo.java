package ubc.cs304.gametrack.entities;

import java.util.UUID;

public class SportInfo {
    private UUID sport_id;
    private String description;
    private String meta;

    public SportInfo(UUID sport_id) {
        this.sport_id = sport_id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getDescription() {
        return description;
    }

    public String getMeta() {
        return meta;
    }
}
