package com.server.impala.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import com.server.impala.model.request.user.CreateUserModel;

import jakarta.validation.Valid;

@RestController
public class AuthController {

    @PostMapping("/auth/create_user")
    public ResponseEntity<String> createUser(@RequestBody @Valid CreateUserModel createUserModel) {
        return ResponseEntity.ok("Ok");
    }
}