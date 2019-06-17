package ubc.cs304.gametrack.controllers.sportinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ubc.cs304.gametrack.entities.SportInfo;

import java.util.List;

@RestController
public class SportInfoController {

    @Autowired
    SportInfoService sportInfoservice;

    @RequestMapping(method= RequestMethod.POST, value="/sportinfos")
    public void createSportInfo(@RequestBody SportInfo sportInfo) {
        sportInfoservice.createSportInfo(sportInfo);
    }

    @RequestMapping(method=RequestMethod.GET, value="/sportinfos")
    public List<SportInfo> getAllSportInfos() {
        return sportInfoservice.findAllSportInfos();
    }

    @RequestMapping(method=RequestMethod.GET, value="/sportinfos/{sportId}")
    public SportInfo getSportInfoBy(@PathVariable String sportId) {
        return sportInfoservice.findSportInfoBy(sportId);
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/sportinfos/name/{sportName}")
    public SportInfo getSportInfoByName(@PathVariable String sportName) {
        return sportInfoservice.findSportInfoBySportName(sportName);
    }
    
    

}
