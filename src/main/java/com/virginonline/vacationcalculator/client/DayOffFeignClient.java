package com.virginonline.vacationcalculator.client;


import java.time.LocalDate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "dayOffService", url = "${date-api.url}")
public interface DayOffFeignClient {


  @GetMapping("/{date}")
  String isDayOff(@DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable LocalDate date);
}
