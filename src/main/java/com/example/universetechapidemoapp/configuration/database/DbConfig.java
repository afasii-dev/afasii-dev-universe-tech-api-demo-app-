package com.example.universetechapidemoapp.configuration.database;

import com.example.universetechapidemoapp.enums.Job;
import com.example.universetechapidemoapp.enums.Status;
import com.example.universetechapidemoapp.model.Employee;
import com.example.universetechapidemoapp.model.SalaryInfo;
import com.example.universetechapidemoapp.model.SalaryManager;
import com.example.universetechapidemoapp.repository.EmployeeRepository;
import com.example.universetechapidemoapp.repository.SalaryManagerRepository;
import com.example.universetechapidemoapp.repository.SalaryRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
@Slf4j
public class DbConfig {

  private final EmployeeRepository employeeRepository;
  private final SalaryRepository salaryRepository;
  private final SalaryManagerRepository salaryManagerRepository;

  @PostConstruct
  public void postConstruct() throws JsonProcessingException {
    var employee = new Employee();
    employee.setFirstName("Alex");
    employee.setLastName("Fasii");
    employee.setDateOfBirth(LocalDate.of(1950, 2, 25));
    employee.setPhone("1234567890");
    employee.setJob(Job.DEVELOPER);
    employeeRepository.save(employee);

    var employee2 = new Employee();
    employee2.setFirstName("John");
    employee2.setLastName("Doe");
    employee2.setDateOfBirth(LocalDate.of(1980, 4, 20));
    employee2.setPhone("986543212");
    employee2.setJob(Job.DEVOPS);
    employeeRepository.save(employee2);

    var counter = 0;
    while (counter <= 2) {
      var salary = new SalaryInfo();
      salary.setEmployee(employee);
      salary.setAmount(5000);
      salary.setReceivedDate(LocalDate.now().withDayOfMonth(1).minusMonths(counter));
      salaryRepository.save(salary);

      var salary2 = new SalaryInfo();
      salary2.setEmployee(employee2);
      salary2.setAmount(10000);
      salary2.setReceivedDate(LocalDate.now().withDayOfMonth(1).minusMonths(counter));
      salaryRepository.save(salary2);

      counter++;
    }

    var salaryManager = new SalaryManager();
    salaryManager.setEmployee(employee);
    salaryManager.setCurrentSalary(5000);
    salaryManager.setScheduledSalary(6000);
    salaryManager.setScheduledDate(LocalDate.now().withDayOfMonth(1).plusMonths(1));
    salaryManager.setStatus(Status.PENDING_APPROVAL);
    salaryManagerRepository.save(salaryManager);

    var salaryManager2 = new SalaryManager();
    salaryManager2.setEmployee(employee2);
    salaryManager2.setCurrentSalary(10000);
    salaryManager2.setScheduledSalary(20000);
    salaryManager2.setScheduledDate(LocalDate.now().withDayOfMonth(1).plusMonths(1));
    salaryManager2.setStatus(Status.PENDING_APPROVAL);
    salaryManagerRepository.save(salaryManager2);
    log.info("POST CONSTRUCT COMPLETED");
  }
}
