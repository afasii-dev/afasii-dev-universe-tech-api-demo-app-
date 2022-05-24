package com.example.universetechapidemoapp.scheduler;

import com.example.universetechapidemoapp.enums.Status;
import com.example.universetechapidemoapp.model.SalaryManager;
import com.example.universetechapidemoapp.repository.SalaryManagerRepository;
import java.time.LocalTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class SalaryScheduler {

  private final SalaryManagerRepository salaryManagerRepository;

  @Scheduled(cron = "@monthly")
  public Iterable<SalaryManager> sync() {
    log.warn("SalaryScheduler started");
    return scheduleSalary();
  }

  private Iterable<SalaryManager> scheduleSalary() {
    var approvedRecords = salaryManagerRepository.findByStatus(Status.APPROVED);
    approvedRecords.forEach(
        approvedRecord -> {
          approvedRecord.setCurrentSalary(approvedRecord.getScheduledSalary());
          log.warn("[RAISE SCHEDULED]: {}", approvedRecord);
        });

    return salaryManagerRepository.saveAll(approvedRecords);
  }
}
