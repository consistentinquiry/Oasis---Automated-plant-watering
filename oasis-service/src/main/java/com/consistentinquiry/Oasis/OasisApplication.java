package com.consistentinquiry.Oasis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication()
@RestController
public class OasisApplication {

  public static void main(String[] args) {
    SpringApplication.run(OasisApplication.class, args);
  }
}
