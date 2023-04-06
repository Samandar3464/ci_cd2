package com.example.ci_cd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class CiCdApplication {

    public static void main(String[] args) {
        SpringApplication.run(CiCdApplication.class, args);
    }

}
