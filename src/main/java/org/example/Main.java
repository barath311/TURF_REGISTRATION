package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // This annotation enables auto-configuration, component scanning, and more
public class Main {

    public static void main(String[] args) {
        // Run the Spring Boot application
        SpringApplication.run(Main.class, args);
    }
}
