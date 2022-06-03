package com.example.universetechapidemoapp.repository;

import com.example.universetechapidemoapp.enums.Status;
import com.example.universetechapidemoapp.model.SalaryManager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryManagerRepository extends CrudRepository<SalaryManager, Long> {
  SalaryManager findByEmployeeId(Long id);

  Iterable<SalaryManager> findByStatus(Status status);
}
