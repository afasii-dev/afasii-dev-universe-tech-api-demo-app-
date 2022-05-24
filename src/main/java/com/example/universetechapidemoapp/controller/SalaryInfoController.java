package com.example.universetechapidemoapp.controller;

import static java.util.Objects.isNull;

import com.example.universetechapidemoapp.model.SalaryInfo;
import com.example.universetechapidemoapp.repository.SalaryInfoRepository;
import com.example.universetechapidemoapp.repository.SalaryManagerRepository;
import com.example.universetechapidemoapp.scheduler.SalaryPayScheduler;
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
@RequestMapping("/v2/salaries")
public class SalaryInfoController {

  private final SalaryInfoRepository salaryInfoRepository;
  private final SalaryManagerRepository salaryManagerRepository;

  private final SalaryPayScheduler salaryPayScheduler;

  @GetMapping
  public Iterable<SalaryInfo> getSalaries() {
    log.info("Salary info controller - find all");
    return salaryInfoRepository.findAll();
  }

  @GetMapping("/{id}")
  public Iterable<SalaryInfo> getSalariesById(@PathVariable Long id) {
    log.info("Salary info controller - get salaries by id : {}", id);
    return salaryInfoRepository.findAllByEmployeeId(id);
  }

  @PostMapping("/{id}")
  public SalaryInfo saveSalary(
      @PathVariable Long id, @RequestParam(required = false) Integer salary) {
    var salaryManager = salaryManagerRepository.findByEmployeeId(id);

    var salaryInfo = new SalaryInfo();
    salaryInfo.setEmployee(salaryManager.getEmployee());
    salaryInfo.setAmount(!isNull(salary) ? salary : salaryManager.getCurrentSalary());
    salaryInfo.setReceivedDate(LocalDate.now());

    log.info("Salary info controller - save salary: {}", salaryInfo);
    return salaryInfoRepository.save(salaryInfo);
  }

  @PostMapping("/trigger-salary-pay")
  public Iterable<SalaryInfo> triggerSalaryScheduler() {
    log.warn("Salary manager controller - trigger salary scheduler");
    return salaryPayScheduler.sync();
  }
}
