package com.javamaster.springsecurityjwt.controller;

import com.javamaster.springsecurityjwt.config.jwt.JwtProvider;
import com.javamaster.springsecurityjwt.entity.UserEntity;
import com.javamaster.springsecurityjwt.service.UserService;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;
    
    @PostMapping("/register")
    @CrossOrigin("*")
    public ResponseEntity<?> registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
        UserEntity u = new UserEntity();
        u.setPassword(registrationRequest.getPassword());
        u.setLogin(registrationRequest.getLogin());
        userService.saveUser(u);
        JSONObject json = new JSONObject();
        json.put("message", "Đăng kí thành công");
        return ResponseEntity.status(200).body(json);
    }

    @PostMapping("/login")
    @CrossOrigin("*")
    public ResponseEntity<?> auth(@RequestBody AuthRequest request) {
        UserEntity userEntity = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(userEntity.getLogin());
        JSONObject json = new JSONObject();
        json.put("token", token);
        json.put("message", "Đăng nhập thành công");
        json.put("user", userEntity);
        return ResponseEntity.status(200).body(json);
    }
}
