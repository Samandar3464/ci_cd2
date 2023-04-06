package com.example.ci_cd.model;

import com.example.ci_cd.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {
    private int id;
    private String username;

    public UserResponseDto(UserEntity userEntity) {
        this.id= userEntity.getId();
        this.username= userEntity.getUsername();
    }
}
