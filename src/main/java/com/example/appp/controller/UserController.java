package com.example.appp.controller;

import com.example.appp.dto.UserDto;
import com.example.appp.entity.User;
import com.example.appp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register/admin")
    public ResponseEntity<User> registerUserAsAdmin(@RequestBody UserDto userDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUserAsAdmin(userDto));
    }
    @PostMapping("/register/client")
    public ResponseEntity<User> registerUserAsClient(@RequestBody UserDto userDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUserAsClient(userDto));
    }
    @PostMapping("/register/manager")
    public ResponseEntity<User> registerUserAsManager(@RequestBody UserDto userDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUserAsManager(userDto));
    }
}
