package com.example.universetechapidemoapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class UniverseTechApiDemoAppApplication {

  public static void main(String[] args) {
    SpringApplication.run(UniverseTechApiDemoAppApplication.class, args);
    log.info("Database url : http://localhost:8080/h2");
  }
}
