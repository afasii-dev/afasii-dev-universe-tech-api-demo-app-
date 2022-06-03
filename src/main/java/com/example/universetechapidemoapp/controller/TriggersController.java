package com.example.universetechapidemoapp.controller;

import com.example.universetechapidemoapp.model.SalaryInfo;
import com.example.universetechapidemoapp.model.SalaryManager;
import com.example.universetechapidemoapp.scheduler.SalaryPayScheduler;
import com.example.universetechapidemoapp.scheduler.SalaryScheduler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v2/triggers")
public class TriggersController {
  private final SalaryPayScheduler salaryPayScheduler;
  private final SalaryScheduler salaryScheduler;

  @PostMapping("/trigger-salary-pay")
  public Iterable<SalaryInfo> triggerSalaryPay() {
    log.warn("Triggers controller - trigger salary pay scheduler");
    return salaryPayScheduler.sync();
  }

  @PostMapping("/trigger-salary-scheduler")
  public Iterable<SalaryManager> triggerSalaryScheduler() {
    log.warn("Triggers controller - trigger salary scheduler");
    return salaryScheduler.sync();
  }
}
