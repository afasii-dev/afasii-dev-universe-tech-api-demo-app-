package com.example.universetechapidemoapp.scheduler;

import com.example.universetechapidemoapp.model.SalaryInfo;
import com.example.universetechapidemoapp.repository.SalaryInfoRepository;
import com.example.universetechapidemoapp.repository.SalaryManagerRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class SalaryPayScheduler {

  private final SalaryManagerRepository salaryManagerRepository;
  private final SalaryInfoRepository salaryInfoRepository;

  @Scheduled(cron = "@monthly")
  public Iterable<SalaryInfo> sync() {
    log.warn("SalaryPayScheduler started");
    return paySalary();
  }

  private Iterable<SalaryInfo> paySalary() {
    var records = salaryManagerRepository.findAll();
    var salariesToPay = new ArrayList<SalaryInfo>();
    records.forEach(
        record -> {
          var salaryInfo = new SalaryInfo();
          salaryInfo.setEmployee(record.getEmployee());
          salaryInfo.setAmount(record.getCurrentSalary());
          salaryInfo.setReceivedDate(LocalDate.now());
          salariesToPay.add(salaryInfo);
        });

    return salaryInfoRepository.saveAll(salariesToPay);
  }
}
