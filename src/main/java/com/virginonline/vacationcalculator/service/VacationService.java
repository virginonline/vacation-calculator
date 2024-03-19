package com.virginonline.vacationcalculator.service;

import java.time.LocalDate;

public interface VacationService {

  double getVacationPayment(double averageSalary, int vacationDays);

  double getVacationPayment(double averageSalary, int vacationDays, LocalDate startVacationDate);
}
