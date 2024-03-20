package com.virginonline.vacationcalculator.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.virginonline.vacationcalculator.client.DayOffFeignClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class VacationServiceImplTest {

  @Mock
  private DayOffFeignClient mockDayOffService;

  private VacationServiceImpl vacationServiceImplUnderTest;

  @BeforeEach
  void setUp() {

    vacationServiceImplUnderTest = new VacationServiceImpl(mockDayOffService);
  }

  @Test
  public void test_calculates_vacation_payment() {
    // Arrange
    double averageSalary = 100000;
    int vacationDays = 20;
    double expectedPayment = 68259.39;

    // Act
    double actualPayment = vacationServiceImplUnderTest.getVacationPayment(averageSalary,
        vacationDays);

    // Assert
    assertEquals(expectedPayment, actualPayment);
  }

  @Test
  public void test_throws_exception_for_negative_average_salary() {
    // Arrange
    double averageSalary = -10000;
    int vacationDays = 20;

    // Act & Assert
    assertThrows(RuntimeException.class,
        () -> vacationServiceImplUnderTest.getVacationPayment(averageSalary, vacationDays));
  }
}
