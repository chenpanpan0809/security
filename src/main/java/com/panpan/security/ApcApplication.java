package com.panpan.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@MapperScan("com.panpan.security.mapper")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApcApplication.class, args);
    }

}
