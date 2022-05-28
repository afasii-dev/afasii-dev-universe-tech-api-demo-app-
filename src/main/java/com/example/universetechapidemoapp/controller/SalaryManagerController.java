package com.example.universetechapidemoapp.controller;

import com.example.universetechapidemoapp.enums.Status;
import com.example.universetechapidemoapp.model.SalaryManager;
import com.example.universetechapidemoapp.repository.SalaryManagerRepository;
import com.example.universetechapidemoapp.scheduler.SalaryScheduler;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v2/salary-manager")
public class SalaryManagerController {
  private final SalaryManagerRepository salaryManagerRepository;

  @GetMapping
  public Iterable<SalaryManager> findAll() {
    log.warn("Salary manager controller - find all");
    return salaryManagerRepository.findAll();
  }

  @GetMapping("/{id}")
  public SalaryManager getByEmployeeId(@PathVariable Long id) {
    log.warn("Salary manager controller - get by id: {}", id);
    return salaryManagerRepository.findByEmployeeId(id);
  }

  @GetMapping("/status")
  public Iterable<SalaryManager> getByStatus(@RequestParam Status status) {
    log.warn("Salary manager controller - get by status: {}", status);
    return salaryManagerRepository.findByStatus(status);
  }

  @PostMapping("/{id}")
  public SalaryManager scheduleSalary(@PathVariable Long id, @RequestParam Integer scheduleSalary) {
    var salaryManager = salaryManagerRepository.findByEmployeeId(id);
    salaryManager.setScheduledSalary(scheduleSalary);
    salaryManager.setScheduledDate(LocalDate.now().withDayOfMonth(1).plusMonths(1));
    salaryManager.setStatus(Status.PENDING_APPROVAL);
    log.warn("Salary manager controller - schedule salary: {}", salaryManager);
    return salaryManagerRepository.save(salaryManager);
  }

  @PostMapping("/status/{id}")
  public SalaryManager setStatus(@PathVariable Long id, @RequestParam Status status) {
    var salaryManager = salaryManagerRepository.findByEmployeeId(id);
    salaryManager.setStatus(status);
    log.warn("Salary manager controller - set status: {}", salaryManager);
    return salaryManagerRepository.save(salaryManager);
  }
}
