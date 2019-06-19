package ubc.cs304.gametrack.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ubc.cs304.gametrack.entities.User;
import ubc.cs304.gametrack.entities.Count;
import ubc.cs304.gametrack.entities.LoginForm;
import ubc.cs304.gametrack.entities.SecuredUser;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method=RequestMethod.POST, value="/users")
    public SecuredUser registerUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @RequestMapping(method=RequestMethod.GET, value="/users")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @RequestMapping(method=RequestMethod.GET, value="/users/{username}")
    public User findUser(@PathVariable String username) {
        return userService.findUserBy(username);
    }

    @RequestMapping(method=RequestMethod.POST, value="/users/login")
    public SecuredUser login(@RequestBody LoginForm form) {
        return userService.login(form.getUsername(), form.getPassword());
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/users/allEvents")
    public List<SecuredUser> getUsersWhoAreInAllEvents() {
        return userService.findUsersWhoParticipatedInAllEvents();
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/users/count")
    public Count getUsersCount() {
    	Count c = new Count();
    	c.count = userService.findNumberOfUsers(); 
    	return c;
    }

}
