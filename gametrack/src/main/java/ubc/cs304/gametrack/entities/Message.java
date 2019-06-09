package ubc.cs304.gametrack.entities;

import java.sql.Timestamp;
import java.util.UUID;

public class Message {
    private UUID message_id;
    private UUID sender_user_id;
    private UUID receiver_user_id;
    private String content;
    private Timestamp message_timestamp;

    public Message() {
    }

    public Message(UUID message_id, UUID sender_user_id, UUID receiver_user_id, String content, Timestamp message_timestamp) {
        this.message_id = message_id;
        this.sender_user_id = sender_user_id;
        this.receiver_user_id = receiver_user_id;
        this.content = content;
        this.message_timestamp = message_timestamp;
    }

    public UUID getMessage_id() {
        return message_id;
    }

    public void setMessage_id(UUID message_id) {
        this.message_id = message_id;
    }

    public UUID getSender_user_id() {
        return sender_user_id;
    }

    public void setSender_user_id(UUID sender_user_id) {
        this.sender_user_id = sender_user_id;
    }

    public UUID getReceiver_user_id() {
        return receiver_user_id;
    }

    public void setReceiver_user_id(UUID receiver_user_id) {
        this.receiver_user_id = receiver_user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getMessage_timestamp() {
        return message_timestamp;
    }

    public void setMessage_timestamp(Timestamp message_timestamp) {
        this.message_timestamp = message_timestamp;
    }
}
