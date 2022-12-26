package com.teng.author;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author:xiaowang
 * @Data:2022/12/26/10:42 Description:
 */
@SpringBootApplication
@MapperScan("com.teng.author.mapper")
public class AuthorApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthorApplication.class, args);
    }
}
