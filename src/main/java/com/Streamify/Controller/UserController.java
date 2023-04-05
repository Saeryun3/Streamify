package com.Streamify.Controller;

import com.Streamify.Model.User;
// import com.Streamify.exception.ResourceNotFoundException;
import com.Streamify.Repository.UserRepository;
import com.Streamify.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    private UserService userService;
    @GetMapping("{ID}")
    public User GetUserById(@PathVariable Long ID) {
        return userRepository.getUserById(ID);
    }
    // Create user REST API
    @PostMapping
    public User CreateUser(@RequestBody User user) {return userRepository.save(user);}


    @PostMapping("/login")
    public ResponseEntity<String> LoginUser(@RequestBody String Email, String Password) {
        if (userService.LoginUser(Email, Password)){
            return new ResponseEntity<>("Login succesfull" HttpStatus.OK);
        } else{
            return new ResponseEntity<>("invalid username or password", HttpStatus.UNAUTHORIZED);
        }
    }
}
