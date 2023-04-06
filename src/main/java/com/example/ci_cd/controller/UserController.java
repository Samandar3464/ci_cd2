package com.example.ci_cd.controller;

import com.example.ci_cd.model.UserLoginDto;
import com.example.ci_cd.model.UserRegisterDto;
import com.example.ci_cd.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestBody UserRegisterDto userRegisterDTO
    ) {
        return userService.register(userRegisterDTO);

    }
}
