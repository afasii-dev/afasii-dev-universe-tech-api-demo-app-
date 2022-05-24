package com.example.universetechapidemoapp.controller;

import com.example.universetechapidemoapp.model.Employee;
import com.example.universetechapidemoapp.repository.EmployeeRepository;
import java.time.LocalTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v2/employees")
public class EmployeeController {

  private final EmployeeRepository employeeRepository;

  @GetMapping
  public Iterable<Employee> findAll() {
    var employees = employeeRepository.findAll();
    log.info("Employee Controller - find all");
    return employeeRepository.findAll();
  }

  @GetMapping("/{id}")
  public Employee getById(@PathVariable Long id) {
    log.info("Employee Controller - get by id: {}", id);
    return employeeRepository.findById(id).get();
  }

  @PostMapping
  public Employee saveEmployee(@RequestBody Employee employee) {
    log.info("Employee Controller - save employee: {}", employee);
    return employeeRepository.save(employee);
  }

  @PutMapping
  public Employee updateEmployee(@RequestBody Employee employee) {
    var employeeToUpdate = employeeRepository.findById(employee.getId()).get();
    BeanUtils.copyProperties(employee, employeeToUpdate);
    log.info("Employee Controller - update employee: {}", employeeToUpdate);
    return employeeRepository.save(employeeToUpdate);
  }

  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping("/{id}")
  public void deleteEmployee(@PathVariable Long id) {
    log.info("Employee Controller - delete employee: {}", id);
    employeeRepository.deleteById(id);
  }
}
