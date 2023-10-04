package com.example.UserDataService.controller;

import com.example.UserDataService.dto.UserRequest;
import com.example.UserDataService.entity.UserData;
import com.example.UserDataService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<String> saveAllUser(@RequestBody UserRequest userRequest)
    {
        return ResponseEntity.ok(userService.saveUserData(userRequest));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserData>> getAll()
    {
        return ResponseEntity.ok(userService.getAllUserData());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Optional<UserData>> getUserId(@PathVariable String userId)
    {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Optional<UserData>> updateDetails(@RequestBody UserRequest userRequest,@PathVariable String userId)
    {
        return ResponseEntity.ok(userService.updateDetails(userRequest,userId));
    }
}
