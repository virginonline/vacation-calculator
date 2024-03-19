package com.virginonline.vacationcalculator.controller;

import com.virginonline.vacationcalculator.service.VacationService;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/vacation")
public class VacationController {

  private final VacationService vacationService;

  @Autowired
  public VacationController(VacationService vacationService) {
    this.vacationService = vacationService;
  }

  @GetMapping("/calculate")
  public double calculatePayment(@RequestParam(name = "averageSalary") double averageSalary,
      @RequestParam(name = "vacationDays") int vacationDays,
      @RequestParam(name = "startVacation", required = false) @DateTimeFormat(iso = ISO.DATE) Optional<LocalDate> startVacationDate) {
    return startVacationDate.map(
            localDate -> vacationService.getVacationPayment(averageSalary, vacationDays,
                localDate))
        .orElseGet(() -> vacationService.getVacationPayment(averageSalary, vacationDays));
  }
}
