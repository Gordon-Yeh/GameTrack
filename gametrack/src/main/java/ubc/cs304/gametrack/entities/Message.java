package ubc.cs304.gametrack.entities;

import java.util.UUID;

public class Message {
    private UUID message_id;
    private UUID sender_user_id;
    private UUID receiver_user_id;
    private String content;
    private long message_timestamp;
    private String sender_username;
    private String receiver_username;

    public Message() {
    }

    public Message(UUID message_id, UUID sender_user_id, UUID receiver_user_id, String content, long message_timestamp) {
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

    public long getMessage_timestamp() {
        return message_timestamp;
    }

    public void setMessage_timestamp(long message_timestamp) {
        this.message_timestamp = message_timestamp;
    }

	public String getSender_username() {
		return sender_username;
	}

	public void setSender_username(String sender_username) {
		this.sender_username = sender_username;
	}

	public String getReceiver_username() {
		return receiver_username;
	}

	public void setReceiver_username(String receiver_username) {
		this.receiver_username = receiver_username;
	}
}
