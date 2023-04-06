package com.example.ci_cd.service;

import com.example.ci_cd.entity.UserEntity;
import com.example.ci_cd.exception.UserAlreadyExistException;
import com.example.ci_cd.exception.UserNotFound;
import com.example.ci_cd.model.UserLoginDto;
import com.example.ci_cd.model.UserRegisterDto;
import com.example.ci_cd.model.UserResponseDto;
import com.example.ci_cd.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public ResponseEntity<?> register(UserRegisterDto userRegisterDTO) {
        Optional<UserEntity> byUsername = userRepository.findByUsername(userRegisterDTO.getUsername());
        if (byUsername.isPresent()) {
            throw new UserAlreadyExistException(String.format("This %s username already exist", userRegisterDTO.getUsername()));
        }
        UserEntity userEntity = UserEntity.builder()
                .username(userRegisterDTO.getUsername())
                .password(userRegisterDTO.getPassword())
                .build();
        UserEntity saveUser = userRepository.save(userEntity);
        return ResponseEntity.ok(new UserResponseDto(saveUser));
    }

    public ResponseEntity<?> login(UserLoginDto userLoginDto) {
        Optional<UserEntity> byUsername = userRepository.findByUsernameAndPassword(userLoginDto.getUsername(), userLoginDto.getPassword());
        if (byUsername.isEmpty()) {
            throw new UserNotFound("User not found");
        }
        return ResponseEntity.ok(byUsername.get());
    }
}
