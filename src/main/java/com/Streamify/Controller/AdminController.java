package com.Streamify.Controller;

import com.Streamify.Model.User;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Streamify.Service.UserService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/")
public class AdminController {
    @Autowired
    private UserService userService;

    @PostMapping("/admin/login")
    public ResponseEntity<Map<String, String>> LoginUser(@RequestBody ObjectNode json) {
        String Email = json.get("email").asText();
        String Password = json.get("password").asText();
        Map<String, String> map = new HashMap<>();
        if (userService.LoginAdmin(Email, Password)) {
            map.put("message", "Login successful");
            map.put("login", "true");
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            map.put("message", "Invalid username or password");
            map.put("login", "false");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
}
