package ubc.cs304.gametrack.controllers.sportdescription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ubc.cs304.gametrack.entities.SportDescription;

import java.util.List;

@RestController
public class SportDescriptionController {

    @Autowired
    SportDescriptionService sportDescriptionService;

    @RequestMapping(method= RequestMethod.POST, value="/descriptions")
    public void createSportDescription(@RequestBody SportDescription sportDescription) {
        sportDescriptionService.createSportDescription(sportDescription);
    }

    @RequestMapping(method=RequestMethod.GET, value="/sports")
    public List<SportDescription> getAllSportDescriptions() {
        return sportDescriptionService.findAllSportDescriptions();
    }

    @RequestMapping(method=RequestMethod.GET, value="/descriptions/{sport_id}")
    public SportDescription getPostalCodeBooking(@PathVariable String sport_id) {
        return sportDescriptionService.findSportDescriptionBy(sport_id);
    }

}
