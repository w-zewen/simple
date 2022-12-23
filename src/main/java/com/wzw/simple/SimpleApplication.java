package com.wzw.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

/**
 * todo
 *
 * @author zewen.wang
 * @date 2022/12/23
 */
@SpringBootApplication
public class SimpleApplication {

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now() + " | " + "Spring Boot SimpleApplication Launch Start");
        SpringApplication.run(SimpleApplication.class, args);
        System.out.println(LocalDateTime.now() + " | " + "Spring Boot SimpleApplication Launch Success");
    }

}
