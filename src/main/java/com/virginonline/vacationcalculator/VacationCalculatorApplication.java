package com.virginonline.vacationcalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class VacationCalculatorApplication {

  public static void main(String[] args) {
    SpringApplication.run(VacationCalculatorApplication.class, args);
  }

}
