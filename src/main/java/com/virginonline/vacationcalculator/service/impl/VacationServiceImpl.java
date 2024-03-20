package com.virginonline.vacationcalculator.service.impl;

import com.virginonline.vacationcalculator.client.DayOffFeignClient;
import com.virginonline.vacationcalculator.service.VacationService;
import com.virginonline.vacationcalculator.utils.SalaryUtils;
import java.time.LocalDate;
import java.util.Objects;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacationServiceImpl implements VacationService {

  /**
   * Среднемесячное число календарных дней
   */
  private static final double DAYS_NUM_AVG_MONTHLY = 29.3;

  private final DayOffFeignClient dayOffService;

  @Autowired
  public VacationServiceImpl(DayOffFeignClient dayOffService) {
    this.dayOffService = dayOffService;
  }


  @Override
  public double getVacationPayment(double averageSalary, int vacationDays) {
    SalaryUtils.validateAverageSalary(averageSalary);
    double vacationSalary = averageSalary / DAYS_NUM_AVG_MONTHLY * vacationDays;
    return SalaryUtils.roundSalary(vacationSalary);
  }

  @Override
  public double getVacationPayment(double averageSalary, int vacationDays,
      LocalDate startVacationDate) {

    SalaryUtils.validateAverageSalary(averageSalary);

    long vacationDaysCount = IntStream.range(0, vacationDays)
        .mapToObj(startVacationDate::plusDays)
        .filter(date -> Objects.equals(dayOffService.isDayOff(date), "0"))
        .count();

    double salary = averageSalary / DAYS_NUM_AVG_MONTHLY * vacationDaysCount;
    return SalaryUtils.roundSalary(salary);
  }
}
