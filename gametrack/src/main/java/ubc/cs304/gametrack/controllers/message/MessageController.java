package ubc.cs304.gametrack.controllers.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ubc.cs304.gametrack.entities.Message;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

    @RequestMapping(method= RequestMethod.POST, value="/messages")
    public void createMessage(@RequestBody Message message) {
        messageService.createMessage(message);
    }

    @RequestMapping(method=RequestMethod.GET, value="/messages")
    public List<Message> getAllMessages() {
        return messageService.findAllMessages();
    }

    @RequestMapping(method=RequestMethod.GET, value="/messages/{message_id}")
    public Message getMessageById(@PathVariable String message_id) {
        return messageService.findMessageById(message_id);
    }

    @RequestMapping(method=RequestMethod.GET, value="/messages_sender/{sender_id}")
    public List<Message> getMessagesBySender(@PathVariable String sender_id) {
        return messageService.findMessagesBySender(sender_id);
    }

    @RequestMapping(method=RequestMethod.GET, value="/messages_receiver/{receiver_id}")
    public List<Message> getMessagesByReceiver(@PathVariable String receiver_id) {
        return messageService.findMessagesByReceiver(receiver_id);
    }

}
