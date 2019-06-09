package ubc.cs304.gametrack.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ubc.cs304.gametrack.entities.User;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method=RequestMethod.POST, value="/users")
    public void registerUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @RequestMapping(method=RequestMethod.GET, value="/users")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @RequestMapping(method=RequestMethod.GET, value="/users/{username}")
    public User findUser(@PathVariable String username) {
        return userService.findUserBy(username);
    }
}
