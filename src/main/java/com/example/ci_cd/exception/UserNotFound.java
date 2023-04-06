package com.example.ci_cd.exception;

public class UserNotFound extends RuntimeException {
    public UserNotFound(String userNotFound) {
        super(userNotFound);
    }
}
