package ubc.cs304.gametrack.entities;

import java.util.UUID;

public class Messages {
    private UUID message_id;
    private UUID sender_user_id;
    private UUID receiver_user_id;
    private String content;
    private int message_timestamp;

    public Messages(UUID message_id, UUID sender_user_id, UUID receiver_user_id, int message_timestamp) {
        this.message_id = message_id;
        this.sender_user_id = sender_user_id;
        this.receiver_user_id = receiver_user_id;
        this.message_timestamp = message_timestamp;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UUID getMessage_id() {
        return message_id;
    }

    public UUID getSender_user_id() {
        return sender_user_id;
    }

    public UUID getReceiver_user_id() {
        return receiver_user_id;
    }

    public String getContent() {
        return content;
    }

    public int getMessage_timestamp() {
        return message_timestamp;
    }
}
