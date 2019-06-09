package ubc.cs304.gametrack.controllers.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ubc.cs304.gametrack.entities.Event;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    EventService eventService;

    @RequestMapping(method= RequestMethod.POST, value="/events")
    public void registerUser(@RequestBody Event event) {
        eventService.createEvent(event);
    }

    @RequestMapping(method=RequestMethod.GET, value="/events")
    public List<Event> getAllEvents() {
        return eventService.findAllEvents();
    }

    @RequestMapping(method=RequestMethod.GET, value="/events/{event_id}")
    public Event findEvent(@PathVariable String event_id) {
        return eventService.findEventBy(event_id);
    }

}
