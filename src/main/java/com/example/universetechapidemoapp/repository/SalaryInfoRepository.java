package com.example.universetechapidemoapp.repository;

import com.example.universetechapidemoapp.model.SalaryInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryInfoRepository extends CrudRepository<SalaryInfo, Long> {
    Iterable<SalaryInfo> findAllByEmployeeId(Long id);
}
