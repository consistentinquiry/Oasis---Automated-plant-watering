package com.consistentinquiry.Oasis;

import java.time.LocalDateTime;

import com.consistentinquiry.Oasis.models.Job;
import com.consistentinquiry.Oasis.repositories.JobRepository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication()
@RestController
public class OasisApplication {

  public static void main(String[] args) {
    SpringApplication.run(OasisApplication.class, args);
  }

  @GetMapping("/login")
  public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    return String.format("Hello %s!", name);
  }

  @Bean
  public CommandLineRunner demo(JobRepository jobRepository){
    return (args) -> {
      LocalDateTime currentDateTime = LocalDateTime.now();
      Log logger = LogFactory.getLog(OasisApplication.class);

      jobRepository.save(new Job(currentDateTime));
      jobRepository.save(new Job(currentDateTime));
      jobRepository.save(new Job(currentDateTime));

      for (Job job : jobRepository.findAll()) {
        logger.info(job.toString());
      }

    };
  }

}
