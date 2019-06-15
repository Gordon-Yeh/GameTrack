package ubc.cs304.gametrack.controllers.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ubc.cs304.gametrack.entities.Message;

import java.util.List;
import java.util.UUID;

@Service
public class MessageService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    void createMessage(Message message) {

        jdbcTemplate.update( "INSERT INTO Message (message_id,sender_user_id,receiver_user_id,content,message_timestamp) VALUES (?,?,?,?,?)",
        UUID.randomUUID().toString(),
        message.getSender_user_id(),
        message.getReceiver_user_id(),
        message.getContent(),
        message.getMessage_timestamp());
    }

    List<Message> findAllMessages() {
        return jdbcTemplate.query("SELECT message_id,sender_user_id,receiver_user_id,content,message_timestamp FROM Message",
                new BeanPropertyRowMapper<Message>(Message.class));
    }

    Message findMessageById(String message_id) {
        List<Message> messages = findAllMessages();
        return messages.stream().filter(m -> m.getMessage_id().toString().equals(message_id)).findFirst().orElse(new Message());
    }

    List<Message> findMessagesBySender(String sender_id) {
        return jdbcTemplate.query("SELECT message_id,sender_user_id,receiver_user_id,content,message_timestamp FROM Message WHERE sender_user_id = '" + sender_id + "'",
                new BeanPropertyRowMapper<Message>(Message.class));
    }

    List<Message> findMessagesByReceiver(String receiver_id) {
        return jdbcTemplate.query("SELECT message_id,sender_user_id,receiver_user_id,content,message_timestamp FROM Message WHERE receiver_user_id = '" + receiver_id + "'",
                new BeanPropertyRowMapper<Message>(Message.class));
    }
}
