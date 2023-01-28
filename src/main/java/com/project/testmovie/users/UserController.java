package com.project.testmovie.users;

import com.project.testmovie.dtos.CreateUserDto;
import com.project.testmovie.dtos.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody CreateUserDto user){
        var createdUser = userService.createUser(user);
        return ResponseEntity.created(URI.create("/users/" +  createdUser.getId())).body(createdUser);
    }

}
