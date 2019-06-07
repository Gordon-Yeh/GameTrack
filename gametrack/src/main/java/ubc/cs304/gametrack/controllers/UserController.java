package ubc.cs304.gametrack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ubc.cs304.gametrack.entities.User;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method=RequestMethod.POST, value="/register")
    public void registerUser(@RequestBody User user) {
        userService.registerUser(user);
    }

    @RequestMapping(method=RequestMethod.GET, value="/register")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @RequestMapping(method=RequestMethod.GET, value="/register/{username}")
    public User findUser(@PathVariable String username) {
        return userService.findUserBy(username);
    }
}
