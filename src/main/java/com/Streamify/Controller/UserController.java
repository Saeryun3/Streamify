package com.Streamify.Controller;

import com.Streamify.Model.User;
// import com.Streamify.exception.ResourceNotFoundException;
import com.Streamify.Repository.UserRepository;
import com.Streamify.Service.UserService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/{ID}")
    public User GetUserById(@PathVariable Long ID) {
        return userService.getUserById(ID);
    }

    @GetMapping("")
    public User GetUserByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }
    // Create user REST API
    @PostMapping
    public User CreateUser(@RequestBody User user) {return userService.save(user);}


    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> LoginUser(@RequestBody ObjectNode json) {
        String Email = json.get("email").asText();
        String Password = json.get("password").asText();
        Map<String, String> map = new HashMap<>();
        if (userService.LoginUser(Email, Password)){
            map.put("message", "Login successful");
            map.put("login", "true");
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else{
            map.put("message", "Invalid username or password");
            map.put("login", "false");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
}
