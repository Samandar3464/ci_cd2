package com.example.ci_cd.controller;

import com.example.ci_cd.model.UserLoginDto;
import com.example.ci_cd.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDto userLoginDto) {
        return userService.login(userLoginDto);
    }
}
