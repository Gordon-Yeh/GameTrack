package ubc.cs304.gametrack.controllers.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ubc.cs304.gametrack.entities.Count;
import ubc.cs304.gametrack.entities.Event;
import ubc.cs304.gametrack.entities.EventForm;

import java.util.List;

@RestController
public class EventController {
	
    @Autowired
    EventService eventService;

    @RequestMapping(method= RequestMethod.POST, value="/events")
    public void createEvent(@RequestBody EventForm form) {
        eventService.createEvent(form);
    }

    @RequestMapping(method= RequestMethod.PUT, value="/events")
    public void editEvent(@RequestBody EventForm form) {
        eventService.editEvent(form);
    }

    @RequestMapping(method=RequestMethod.GET, value="/events")
    public List<Event> getAllEvents() {
        return eventService.findAllEvents();
    }

    @RequestMapping(method=RequestMethod.GET, value="/events/{event_id}")
    public Event findEvent(@PathVariable String event_id) {
        return eventService.findEventBy(event_id);
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/events/user_id={user_id}")
    public List<Event> findEventsCreatedBy(@PathVariable String user_id) {
        return eventService.findEventsByHost(user_id);
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/events/filtered")
    public List<Event> findEventsByFilter(@RequestBody Filter filters) {
        return eventService.filterEvents(filters);
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/eventsUserJoined/{userId}")
    public List<Event> findEventsUserJoined(@PathVariable String userId) {
    	return eventService.getEventsUserIsParticipatingIn(userId);
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/events/count")
    public Count getEventsCount() {
    	Count c = new Count();
    	c.count = eventService.findNumberOfEvents();
    	return c;
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/events/projected")
    public List<Event> findAllEventsProjected(@RequestBody ProjectionFilter filters) {
        return eventService.findEventsAndProject(filters);
    }

}
