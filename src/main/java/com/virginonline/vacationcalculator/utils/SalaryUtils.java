package com.virginonline.vacationcalculator.utils;


import java.math.BigDecimal;
import java.math.RoundingMode;

public final class SalaryUtils {

  private SalaryUtils() {
    throw new AssertionError("SalaryUtils class should not be instantiated");
  }

  public static void validateAverageSalary(double averageSalary) {
    if (averageSalary <= 0) {
      throw new RuntimeException(
          "Средняя годовая зарплата должна быть положительным числом и больше нуля");
    }
  }

  public static double roundSalary(double salary) {
    BigDecimal result = new BigDecimal(salary).setScale(2, RoundingMode.HALF_UP);
    return result.doubleValue();
  }
}
